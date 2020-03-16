package finki.ukim.mk.carrent.service;

import finki.ukim.mk.carrent.model.Car;

import java.util.List;
import java.util.Optional;

public interface CarService {

    Optional<Car> findById(Long carId);

    Car createCar(Long carId, String mark, String model, String color, int yearOfProduction, int cost, Long renterId);

    List<Car> getAllCars();

    List<Car> searchCarsByName(String name);

    void deleteById(Long carId);

    void setRating(Long carId, int rating);

    List<Car> getAllOwnedCarsById(Long renterId);
}
