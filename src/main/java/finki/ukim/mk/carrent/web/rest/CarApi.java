package finki.ukim.mk.carrent.web.rest;

import finki.ukim.mk.carrent.model.Car;
import finki.ukim.mk.carrent.model.CarHistory;
import finki.ukim.mk.carrent.model.Termin;
import finki.ukim.mk.carrent.service.CarHistoryService;
import finki.ukim.mk.carrent.service.CarService;
import finki.ukim.mk.carrent.service.TerminService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/cars")
public class CarApi {

    private final CarService carService;
    private final TerminService terminService;
    private final CarHistoryService carHistoryService;

    public CarApi(CarService carService, TerminService terminService, CarHistoryService carHistoryService) {
        this.carService = carService;
        this.terminService = terminService;
        this.carHistoryService = carHistoryService;
    }

    @GetMapping("/{carId}")
    @PreAuthorize("hasRole('USER') or hasRole('RENTER') or hasRole('ADMIN')")
    public Car getCar(@PathVariable Long carId){
        return this.carService.findById(carId);
    }

    @GetMapping("/{carId}/termines")
    @PreAuthorize("hasRole('USER') or hasRole('RENTER') or hasRole('ADMIN')")
    public List<Termin> getCarTermines(@PathVariable Long carId){
        return this.terminService.getTerminesByCarId(carId);
    }

    @PostMapping
    @PreAuthorize("hasRole('RENTER')")
    public Car addCar(@RequestHeader Long renterId,
                      @RequestParam String plate,
                      @RequestParam String mark,
                      @RequestParam String model,
                      @RequestParam String color,
                      @RequestParam int yearOfProduction,
                      @RequestParam int costPerDay,
                      @RequestParam String imgLink
                      ){
        return this.carService.createCar(plate, mark, model, color, yearOfProduction, costPerDay, imgLink, renterId);
    }

    @GetMapping
    @PreAuthorize("hasRole('USER') or hasRole('RENTER') or hasRole('ADMIN')")
    public List<Car> getAllCars(){
        return this.carService.getAllCars();
    }

    @DeleteMapping("/{carId}")
    @PreAuthorize("hasRole('RENTER')")
    public void deleteCar(@PathVariable Long carId){
        this.carService.deleteById(carId);
    }

    @GetMapping(params = "mark")
    @PreAuthorize("hasRole('USER') or hasRole('RENTER') or hasRole('ADMIN')")
    public List<Car> searchCarsByMark(@RequestParam String mark){
        return this.carService.searchCarsByMark(mark);
    }

    @PatchMapping("/rating/{carId}")
    @PreAuthorize("hasRole('USER')")
    public void setRating(@PathVariable Long carId, @RequestHeader int rating){
        this.carService.setRating(carId, rating);
    }

    @GetMapping("/renter/{renterId}")
    @PreAuthorize("hasRole('USER') or hasRole('RENTER') or hasRole('ADMIN')")
    public List<Car> getCarsByOwner(@PathVariable Long renterId){
        return this.carService.getAllOwnedCarsById(renterId);
    }

    @PatchMapping("/{carId}")
    @PreAuthorize("hasRole('RENTER')")
    public Car editCar(@PathVariable Long carId,
                       @RequestHeader Long renterId,
                       @RequestParam String plate,
                       @RequestParam String mark,
                       @RequestParam String model,
                       @RequestParam String color,
                       @RequestParam int yearOfProduction,
                       @RequestParam int costPerDay,
                       @RequestParam String imgLink
    ){
        return this.carService.editCar(carId, plate, mark, model, color, yearOfProduction, costPerDay, imgLink, renterId);
    }

    @PostMapping("/carHistories")
    @PreAuthorize("hasRole('USER') or hasRole('RENTER') or hasRole('ADMIN')")
    public CarHistory createCarHistory(@RequestHeader Long carId,
                                       @RequestParam("registrationDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate registrationDate,
                                       @RequestParam String breaksStatus,
                                       @RequestParam String frontGlassStatus,
                                       @RequestParam String wheelsStatus,
                                       @RequestParam String engineStatus,
                                       @RequestParam int kmDistancePassed,
                                       @RequestParam String detailsDescription
                                        ){
        return this.carHistoryService.createCarHistory(registrationDate, breaksStatus, frontGlassStatus, wheelsStatus, engineStatus, kmDistancePassed, detailsDescription, carId);
    }

    @DeleteMapping("/carHistories/{historyId}")
    @PreAuthorize("hasRole('RENTER')")
    public void deleteCarHistory(@PathVariable Long historyId){
        this.carHistoryService.deleteById(historyId);
    }

    @GetMapping("carHistories/{carId}")
    @PreAuthorize("hasRole('USER') or hasRole('RENTER') or hasRole('ADMIN')")
    public List<CarHistory> getHistoriesByCar(@PathVariable Long carId){
        return this.carHistoryService.searchByCarId(carId);
    }

    @PatchMapping("/carHistories/{historyId}")
    @PreAuthorize("hasRole('RENTER')")
    public CarHistory editCarHistory(@PathVariable Long historyId,
                                     @RequestHeader Long carId,
                                     @RequestParam("registrationDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate registrationDate,
                                     @RequestParam String breaksStatus,
                                     @RequestParam String frontGlassStatus,
                                     @RequestParam String wheelsStatus,
                                     @RequestParam String engineStatus,
                                     @RequestParam int kmDistancePassed,
                                     @RequestParam String detailsDescription
                                     ){
        return this.carHistoryService.editHistory(historyId, carId, registrationDate, breaksStatus, frontGlassStatus, wheelsStatus, engineStatus, kmDistancePassed, detailsDescription);
    }

}
