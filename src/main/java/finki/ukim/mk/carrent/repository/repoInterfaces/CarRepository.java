package finki.ukim.mk.carrent.repository.repoInterfaces;

import finki.ukim.mk.carrent.model.Car;

import java.util.List;
import java.util.Optional;

public interface CarRepository {

    Optional<Car> findById(Long carId);

    Car save(Car car);

    List<Car> getAllCars();

    List<Car> searchCarsByMark(String mark);

    void deleteById(Long carId);

    List<Car> getAllOwnedCarsByRenterId(Long renterId);  // This should be here, not in RenterRepo!?

}
