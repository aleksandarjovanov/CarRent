package finki.ukim.mk.carrent.repository.inMemory;

import finki.ukim.mk.carrent.model.Car;
import finki.ukim.mk.carrent.model.Termin;

import java.util.List;
import java.util.Optional;

public interface CarRepository {

    Optional<Car> findById(String carId);

    Car save(Car car);

    List<Car> getAllCars();

    List<Car> searchCarsByName(String name);

    void deleteById(String carId);

    List<Car> getAllOwnedCarsById(String renterId);  // This should be here, not in RenterRepo!?

}
