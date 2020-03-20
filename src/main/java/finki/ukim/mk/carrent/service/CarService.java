package finki.ukim.mk.carrent.service;

import finki.ukim.mk.carrent.model.Car;

import java.util.List;
import java.util.Optional;

public interface CarService {

    Car findById(Long carId);

    Car createCar(String plate, String mark, String model, String color, int yearOfProduction, int cost, String imgLink, Long renterId);

    List<Car> getAllCars();

    List<Car> searchCarsByMark(String mark);

    void deleteById(Long carId);

    void setRating(Long carId, int rating);

    List<Car> getAllOwnedCarsById(Long renterId);
}
