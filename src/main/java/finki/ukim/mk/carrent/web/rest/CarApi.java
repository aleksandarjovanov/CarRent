package finki.ukim.mk.carrent.web.rest;

import finki.ukim.mk.carrent.model.Car;
import finki.ukim.mk.carrent.model.CarHistory;
import finki.ukim.mk.carrent.model.Client;
import finki.ukim.mk.carrent.model.combinedResult.CarAndTerminesCombined;
import finki.ukim.mk.carrent.service.CarHistoryService;
import finki.ukim.mk.carrent.service.CarService;
import finki.ukim.mk.carrent.service.TerminService;
import org.springframework.web.bind.annotation.*;

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
    public Car getCar(@PathVariable Long carId){
        return this.carService.findById(carId);
    }

    @GetMapping("/{carId}/termines")
    public CarAndTerminesCombined getCarAndTermines(@PathVariable Long carId){
        return new CarAndTerminesCombined(this.carService.findById(carId), this.terminService.getTerminesByCarId(carId));
    }

    @PostMapping
    public Car addCar(@RequestHeader Long renterId,
                      @RequestParam String plate,
                      @RequestParam String mark,
                      @RequestParam String model,
                      @RequestParam String color,
                      @RequestParam int yearOfProduction,
                      @RequestParam int cost,
                      @RequestParam String imgLink
                      ){
        return this.carService.createCar(plate, mark, model, color, yearOfProduction, cost, imgLink, renterId);
    }

    @GetMapping
    public List<Car> getAllCars(){
        return this.carService.getAllCars();
    }

    @DeleteMapping("/{carId}")
    public void deleteCar(@PathVariable Long carId){
        this.carService.deleteById(carId);
    }

    @GetMapping(params = "mark")
    public List<Car> searchCarsByMark(@RequestParam String mark){
        return this.carService.searchCarsByMark(mark);
    }

    @PostMapping("/{carId}")
    public void setRating(@PathVariable Long carId, @RequestHeader int rating){
        this.carService.setRating(carId, rating);
    }

    @GetMapping("/renter/{renterId}")
    public List<Car> getCarsByOwner(@PathVariable Long renterId){
        return this.carService.getAllOwnedCarsById(renterId);
    }

    @PatchMapping("/{carId}")
    public Car editCar(@PathVariable Long carId,
                       @RequestHeader Long renterId,
                       @RequestParam String plate,
                       @RequestParam String mark,
                       @RequestParam String model,
                       @RequestParam String color,
                       @RequestParam int yearOfProduction,
                       @RequestParam int cost,
                       @RequestParam String imgLink
    ){
        return this.carService.editCar(carId, plate, mark, model, color, yearOfProduction, cost, imgLink, renterId);
    }


}
