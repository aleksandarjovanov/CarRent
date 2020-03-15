package finki.ukim.mk.carrent.service;

import finki.ukim.mk.carrent.model.Car;

import java.util.List;
import java.util.Optional;

public interface CarService {

    Optional<Car> findById(String carId);

    Car createCar(String carId, String mark, String model, String color, int yearOfProduction, int cost, String renterId);

    List<Car> getAllCars();

    List<Car> searchCarsByName(String name);

    void deleteById(String carId);

    void setRating(int rating);

    List<Car> getAllOwnedCarsById(String renterId);
}
