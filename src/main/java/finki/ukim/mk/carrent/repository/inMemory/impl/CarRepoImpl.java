package finki.ukim.mk.carrent.repository.inMemory.impl;

import finki.ukim.mk.carrent.model.Car;
import finki.ukim.mk.carrent.model.LocalData.InMemoryData;
import finki.ukim.mk.carrent.repository.inMemory.CarRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class CarRepoImpl implements CarRepository {
    @Override
    public Optional<Car> findById(String carId) {
        return InMemoryData.cars.stream().filter(car -> car.getPlate().equals(carId)).findFirst();
    }

    @Override
    public Car save(Car car) {
        this.findById(car.getPlate()).ifPresent(car1 -> InMemoryData.cars.remove(car1));
        InMemoryData.cars.add(car);
        return car;
    }

    @Override
    public List<Car> getAllCars() {
        return InMemoryData.cars;
    }

    @Override
    public List<Car> searchCarsByName(String name) {
        return InMemoryData.cars.stream().filter(car -> car.getPlate().equals(name)).collect(Collectors.toList());
    }

    @Override
    public void deleteById(String carId) {
        this.findById(carId).ifPresent(car1 -> InMemoryData.cars.remove(car1));
    }

    @Override
    public List<Car> getAllOwnedCarsById(String renterId) {
        return InMemoryData.cars.stream().filter(car -> car.getRenter().getEmbg().equals(renterId)).collect(Collectors.toList());
    }
}
