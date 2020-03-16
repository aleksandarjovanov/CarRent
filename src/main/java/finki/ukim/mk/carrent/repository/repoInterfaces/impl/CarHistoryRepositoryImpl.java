package finki.ukim.mk.carrent.repository.repoInterfaces.impl;

import finki.ukim.mk.carrent.model.CarHistory;
import finki.ukim.mk.carrent.repository.jpa.JpaCarHistoryRepository;
import finki.ukim.mk.carrent.repository.repoInterfaces.CarHistoryRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CarHistoryRepositoryImpl implements CarHistoryRepository {

    private final JpaCarHistoryRepository jpaCarHistoryRepository;

    public CarHistoryRepositoryImpl(JpaCarHistoryRepository jpaCarHistoryRepository) {
        this.jpaCarHistoryRepository = jpaCarHistoryRepository;
    }

    @Override
    public Optional<CarHistory> findById(Long carHistoryId) {
        return jpaCarHistoryRepository.findById(carHistoryId);
    }

    @Override
    public CarHistory save(CarHistory history) {
        return jpaCarHistoryRepository.save(history);
    }

    @Override
    public List<CarHistory> getAll() {
        return jpaCarHistoryRepository.findAll();
    }

    @Override
    public List<CarHistory> searchByCarId(Long carId) {
        return null;  // TUKA ZASTANAH SINOKE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    }

    @Override
    public void deleteById(Long carHistoryId) {
        jpaCarHistoryRepository.deleteById(carHistoryId);
    }
}
