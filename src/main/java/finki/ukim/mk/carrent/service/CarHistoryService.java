package finki.ukim.mk.carrent.service;

import finki.ukim.mk.carrent.model.CarHistory;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface CarHistoryService {
    Optional<CarHistory> findById(Long carHistoryId);

    CarHistory createCarHistory(LocalDate registrationDate, String breaksStatus, String frontGlssStatus, String wheelStatus, String engineStatus, int kmPassed, String description, String carId);

    List<CarHistory> getAll();

    List<CarHistory> searchByCarId(String carId);

    void deleteById(Long carHistoryId);
}
