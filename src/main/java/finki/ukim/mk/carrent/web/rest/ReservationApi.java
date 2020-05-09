package finki.ukim.mk.carrent.web.rest;

import finki.ukim.mk.carrent.model.Reservation;
import finki.ukim.mk.carrent.service.CarService;
import finki.ukim.mk.carrent.service.ClientService;
import finki.ukim.mk.carrent.service.ReservationService;
import net.bytebuddy.asm.Advice;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/reservations")
public class ReservationApi {

    private final ClientService clientService;
    private final CarService carService;
    private final ReservationService reservationService;

    public ReservationApi(ClientService clientService, CarService carService, ReservationService reservationService) {
        this.clientService = clientService;
        this.carService = carService;
        this.reservationService = reservationService;
    }

    @GetMapping("/{reservationId}")
    @PreAuthorize("hasRole('USER') or hasRole('RENTER') or hasRole('ADMIN')")
    public Reservation getReservation(@PathVariable Long reservationId){
        return this.reservationService.findById(reservationId);
    }

    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public void addReservation(@RequestHeader Long clientId,
                                      @RequestHeader Long carId,
                                      @RequestParam String comment,
                                      @RequestParam("from") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
                                      @RequestParam("to") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to,
                                      HttpServletResponse response
                                      ) throws IOException {
        if(from.compareTo(to) >= 0){
            response.sendRedirect("/reservations/error");   // not sure
        }
        else{
            this.reservationService.createReservation(clientId, carId, comment, from, to);
        }
    }

    @GetMapping("/error")
    @PreAuthorize("hasRole('USER') or hasRole('RENTER') or hasRole('ADMIN')")
    public String errorMessage(){
        return "Please input correct dates";
    }

    @GetMapping
    @PreAuthorize("hasRole('USER') or hasRole('RENTER') or hasRole('ADMIN')")
    public List<Reservation> getAllReservation(){
        return this.reservationService.getAllReservations();
    }

    @DeleteMapping("/{reservationId}")
    @PreAuthorize("hasRole('USER') or hasRole('RENTER')")
    public void deleteReservation(@PathVariable Long reservationId){
        this.reservationService.deleteById(reservationId);
    }

    @GetMapping(params = "clientId")
    @PreAuthorize("hasRole('USER')")
    public List<Reservation> getReservationsByClient(@RequestParam Long clientId){
        return this.reservationService.getReservationsByClientId(clientId);
    }

    @GetMapping(params = "renterId")
    @PreAuthorize("hasRole('RENTER')")
    public List<Reservation> getReservationsByRenter(@RequestParam Long renterId){
        return this.reservationService.getReservationsByRenterId(renterId);
    }

    @GetMapping(params = "name")
    @PreAuthorize("hasRole('USER') or hasRole('RENTER') or hasRole('ADMIN')")
    public List<Reservation> getReservationsByClientName(@RequestParam String name){
        return this.reservationService.getReservationsByClientName(name);
    }

    @GetMapping("/active")
    @PreAuthorize("hasRole('USER') or hasRole('RENTER') or hasRole('ADMIN')")
    public List<Reservation> getActiveReservations(){
        return this.reservationService.getActiveReservations(LocalDate.of(2020, 4, 1));
    }

}
