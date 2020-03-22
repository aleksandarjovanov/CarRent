package finki.ukim.mk.carrent.repository.repoInterfaces.impl;

import finki.ukim.mk.carrent.model.Car;
import finki.ukim.mk.carrent.repository.jpa.JpaCarRepository;
import finki.ukim.mk.carrent.repository.repoInterfaces.CarRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CarRepositoryImpl implements CarRepository {

    private final JpaCarRepository jpaCarRepository;

    public CarRepositoryImpl(JpaCarRepository jpaCarRepository) {
        this.jpaCarRepository = jpaCarRepository;
    }

    @Override
    public Optional<Car> findById(Long carId) {
        return jpaCarRepository.findById(carId);
    }

    @Override
    public Car save(Car car) {
        return jpaCarRepository.save(car);
    }

    @Override
    public List<Car> getAllCars() {
        return jpaCarRepository.findAll();
    }

    @Override
    public List<Car> searchCarsByMark(String mark) {
        return jpaCarRepository.findByMarkContaining(mark);
    }

    @Override
    public void deleteById(Long carId) {
        jpaCarRepository.deleteById(carId);
    }

    @Override
    public List<Car> getAllOwnedCarsByRenterId(Long renterId) {
        return jpaCarRepository.findByRenter_Id(renterId);
    }
}
