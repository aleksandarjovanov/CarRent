package finki.ukim.mk.carrent.service.impl;

import finki.ukim.mk.carrent.model.Car;
import finki.ukim.mk.carrent.model.CarHistory;
import finki.ukim.mk.carrent.model.exceptions.InvalidCarException;
import finki.ukim.mk.carrent.model.exceptions.InvalidCarHistoryException;
import finki.ukim.mk.carrent.repository.repoInterfaces.CarHistoryRepository;
import finki.ukim.mk.carrent.repository.repoInterfaces.CarRepository;
import finki.ukim.mk.carrent.service.CarHistoryService;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CarHistoryServiceImpl implements CarHistoryService {

    private final CarHistoryRepository carHistoryRepository;
    private final CarRepository carRepository;

    public CarHistoryServiceImpl(CarHistoryRepository carHistoryRepository, CarRepository carRepository) {
        this.carHistoryRepository = carHistoryRepository;
        this.carRepository = carRepository;
    }

    @Override
    public CarHistory findById(Long carHistoryId) {
        return this.carHistoryRepository.findById(carHistoryId).orElseThrow(InvalidCarHistoryException::new);
    }

    @Override
    public CarHistory createCarHistory(LocalDate registrationDate, String breaksStatus, String frontGlassStatus, String wheelStatus, String engineStatus, int kmPassed, String description, Long carId) {
        Car car = this.carRepository.findById(carId).orElseThrow(InvalidCarException::new);
        CarHistory carHistory = new CarHistory();
        carHistory.createCarHistory(registrationDate, breaksStatus, frontGlassStatus, wheelStatus, engineStatus, kmPassed, description, car);
        return this.carHistoryRepository.save(carHistory);
    }

    @Override
    public List<CarHistory> getAll() {
        return this.carHistoryRepository.getAll();
    }

    @Override
    public List<CarHistory> searchByCarId(Long carId) {
        return this.carHistoryRepository.getAllHistoriesByCarId(carId);
    }

    @Override
    public void deleteById(Long carHistoryId) {
        this.carHistoryRepository.deleteById(carHistoryId);
    }
}
