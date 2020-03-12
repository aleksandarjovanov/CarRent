package finki.ukim.mk.carrent.repository;

import finki.ukim.mk.carrent.model.Car;

import java.util.List;
import java.util.Optional;

public interface CarRepository {

    Optional<Car> findById(String carId);
    void save(Car car);
    List<Car> getAllOwnedCarsById(String renterId);  // This should be here, not in RenterRepo!?

}
