package finki.ukim.mk.carrent.web.rest;


import finki.ukim.mk.carrent.model.Admin;
import finki.ukim.mk.carrent.model.Client;
import finki.ukim.mk.carrent.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/admin")
public class AdminApi {

    @Autowired
    private AdminService adminService;

    @GetMapping("/{adminId}")
    @PreAuthorize("hasRole('ADMIN')")
    public Admin getAdmin(@PathVariable Long adminId){
        return this.adminService.findById(adminId);
    }

}
