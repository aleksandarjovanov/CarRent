package finki.ukim.mk.carrent.web.rest;

import finki.ukim.mk.carrent.model.Reservation;
import finki.ukim.mk.carrent.service.CarService;
import finki.ukim.mk.carrent.service.ClientService;
import finki.ukim.mk.carrent.service.ReservationService;
import net.bytebuddy.asm.Advice;
import org.springframework.format.annotation.DateTimeFormat;
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
    public Reservation getReservation(@PathVariable Long reservationId){
        return this.reservationService.findById(reservationId);
    }

    @PostMapping
    public Reservation addReservation(@RequestHeader Long clientId,
                                      @RequestHeader Long carId,
                                      @RequestParam String comment,
                                      @RequestParam("from") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
                                      @RequestParam("to") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to,
                                      HttpServletResponse response
                                      ) throws IOException {
        return this.reservationService.createReservation(clientId, carId, comment, from, to);
    }

    @GetMapping("/error") //no-usage
    public String errorMessage(){
        return "Please input correct dates";
    }

    @GetMapping
    public List<Reservation> getAllReservation(){
        return this.reservationService.getAllReservations();
    }

    @DeleteMapping("/{reservationId}")
    public void deleteReservation(@PathVariable Long reservationId){
        this.reservationService.deleteById(reservationId);
    }

    @GetMapping(params = "clientId")
    public List<Reservation> getReservationsByClient(@RequestParam Long clientId){
        return this.reservationService.getReservationsByClientId(clientId);
    }

    @GetMapping(params = "renterId")
    public List<Reservation> getReservationsByRenter(@RequestParam Long renterId){
        return this.reservationService.getReservationsByRenterId(renterId);
    }

    @GetMapping(params = "name")
    public List<Reservation> getReservationsByClientName(@RequestParam String name){
        return this.reservationService.getReservationsByClientName(name);
    }

    @GetMapping("/active")
    public List<Reservation> getActiveReservations(){
        return this.reservationService.getActiveReservations(LocalDate.of(2020, 4, 1));
    }

}
