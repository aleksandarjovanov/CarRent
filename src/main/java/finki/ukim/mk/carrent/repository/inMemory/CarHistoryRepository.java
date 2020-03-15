package finki.ukim.mk.carrent.repository.inMemory;

import finki.ukim.mk.carrent.model.Car;
import finki.ukim.mk.carrent.model.CarHistory;

import java.util.List;
import java.util.Optional;

public interface CarHistoryRepository {
    Optional<CarHistory> findById(Long carHistoryId);

    CarHistory save(CarHistory history);

    List<CarHistory> getAll();

    List<CarHistory> searchByCarId(String carId);

    void deleteById(Long carHistoryId);
}
