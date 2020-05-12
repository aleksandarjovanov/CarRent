package finki.ukim.mk.carrent.web.rest.AuthController;

import finki.ukim.mk.carrent.model.ERole;
import finki.ukim.mk.carrent.model.Log;
import finki.ukim.mk.carrent.model.Role;
import finki.ukim.mk.carrent.model.User;
import finki.ukim.mk.carrent.repository.repoInterfaces.RoleRepository;
import finki.ukim.mk.carrent.repository.repoInterfaces.UserRepository;
import finki.ukim.mk.carrent.security.jwt.JwtUtils;
import finki.ukim.mk.carrent.security.payload.request.LoginRequest;
import finki.ukim.mk.carrent.security.payload.request.SignupRequest;
import finki.ukim.mk.carrent.security.payload.request.SignupRequestAdmin;
import finki.ukim.mk.carrent.security.payload.request.SignupRequestRenter;
import finki.ukim.mk.carrent.security.payload.response.JwtResponse;
import finki.ukim.mk.carrent.security.payload.response.MessageResponse;
import finki.ukim.mk.carrent.security.services.UserDetailsImpl;
import finki.ukim.mk.carrent.service.AdminService;
import finki.ukim.mk.carrent.service.ClientService;
import finki.ukim.mk.carrent.service.LogService;
import finki.ukim.mk.carrent.service.RenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    ClientService clientService;

    @Autowired
    RenterService renterService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    LogService logService;

    @Autowired
    AdminService adminService;

    @Autowired
    JwtUtils jwtUtils;

    public Log catchSignInAttempt(String jwt, String username, String role, String ipAddress, LocalDateTime from, boolean isSuccess) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return logService.createLog(jwt, role, username, ipAddress, isSuccess, from.format(format), null, 0.0);
    }

    @PostMapping("/logout")
    public void logoutUser(@RequestHeader Long logId){
        Log log = logService.findById(logId);

        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        DateTimeFormatter format2 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        String timeTo = LocalDateTime.now().format(format1);
        LocalDateTime timeFrom = LocalDateTime.parse(log.getFromTime(), format2);

        double totalHours = ChronoUnit.MINUTES.between(timeFrom, LocalDateTime.of(2020, Month.MAY, 13, 22, 10,10));

        log.setTotalHours(totalHours);
        log.setToTime(timeTo);
        logService.update(log);
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest, HttpServletRequest request) {

        Authentication authentication = null;
        try {
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        }catch (Exception e){

            String ipAddress = request.getRemoteAddr();
            catchSignInAttempt(null, loginRequest.getUsername(), null, ipAddress, LocalDateTime.now(), false);
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Bad credentials, please try again!"));
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        String ipAddress = request.getRemoteAddr();
        Log log = catchSignInAttempt(jwt, userDetails.getUsername(), roles.get(0), ipAddress, LocalDateTime.now(), true);
        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles, log.getId()));
    }

    @PostMapping("/signupClient")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        // Create new user's account
        User user = new User(signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()));

        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;
                    case "renter":
                        Role modRole = roleRepository.findByName(ERole.ROLE_RENTER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(modRole);

                        break;
                    default:
                        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }

        user.setRoles(roles);
        userRepository.save(user);
        User tmpUser = userRepository.findByUsername(user.getUsername()).orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + signUpRequest.getUsername()));
        clientService.createClient(tmpUser.getId(),signUpRequest.getEmbg(), signUpRequest.getFirstName(), signUpRequest.getLastName(), signUpRequest.getAge(),
                signUpRequest.getSex(), signUpRequest.getDriverLicenceNumber(), signUpRequest.isCrimeRecord(), signUpRequest.getImgUrl());

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

    @PostMapping("/signupRenter")
    public ResponseEntity<?> registerUserRenter(@Valid @RequestBody SignupRequestRenter signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        // Create new user's account
        User user = new User(signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()));

        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;
                    case "renter":
                        Role modRole = roleRepository.findByName(ERole.ROLE_RENTER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(modRole);

                        break;
                    default:
                        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }

        user.setRoles(roles);
        userRepository.save(user);
        User tmpUser = userRepository.findByUsername(user.getUsername()).orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + signUpRequest.getUsername()));
        renterService.createRenter(tmpUser.getId(),signUpRequest.getEmbg(), signUpRequest.getFirstName(), signUpRequest.getLastName(), signUpRequest.getAge(),
                signUpRequest.getSex(), signUpRequest.getImgUrl(), new ArrayList<>());

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

    @PostMapping("/signupAdmin")
    public ResponseEntity<?> registerUserAdmin(@Valid @RequestBody SignupRequestAdmin signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        // Create new user's account
        User user = new User(signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()));

        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;
                    case "renter":
                        Role modRole = roleRepository.findByName(ERole.ROLE_RENTER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(modRole);

                        break;
                    default:
                        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }

        user.setRoles(roles);
        userRepository.save(user);
        User tmpUser = userRepository.findByUsername(user.getUsername()).orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + signUpRequest.getUsername()));
        adminService.createAdmin(tmpUser.getId(), signUpRequest.getFirstName(), signUpRequest.getLastName(), signUpRequest.getImgUrl());

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }


}