package finki.ukim.mk.carrent.repository.inMemory.impl;

import finki.ukim.mk.carrent.model.Car;
import finki.ukim.mk.carrent.model.CarHistory;
import finki.ukim.mk.carrent.model.LocalData.InMemoryData;
import finki.ukim.mk.carrent.repository.inMemory.CarHistoryRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class CarHistoryRepoImpl implements CarHistoryRepository {
    @Override
    public Optional<CarHistory> findById(int carHistoryId) {
        return InMemoryData.carHistories.stream().filter(carHistory -> carHistory.getId() == carHistoryId).findFirst();
    }

    @Override
    public CarHistory save(CarHistory history) {
        this.findById(history.getId()).ifPresent(history1 -> InMemoryData.carHistories.remove(history1));
        InMemoryData.carHistories.add(history);
        return history;
    }

    @Override
    public List<CarHistory> getAll() {
        return InMemoryData.carHistories;
    }

    @Override
    public List<CarHistory> searchByCarId(String carId) {
        return InMemoryData.carHistories.stream().filter(carHistory -> carHistory.getCar().getPlate().equals(carId)).collect(Collectors.toList());
    }

    @Override
    public void deleteById(int carHistoryId) {
        this.findById(carHistoryId).ifPresent(carHistory -> InMemoryData.carHistories.remove(carHistory));
    }
}
