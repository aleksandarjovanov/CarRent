package finki.ukim.mk.carrent.repository.repoInterfaces.impl;

import finki.ukim.mk.carrent.model.Termin;
import finki.ukim.mk.carrent.repository.jpa.JpaTerminRepository;
import finki.ukim.mk.carrent.repository.repoInterfaces.TerminRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TerminRepositoryImpl implements TerminRepository {

    private final JpaTerminRepository jpaTerminRepository;

    public TerminRepositoryImpl(JpaTerminRepository jpaTerminRepository) {
        this.jpaTerminRepository = jpaTerminRepository;
    }

    @Override
    public Optional<Termin> findById(Long terminId) {
        return jpaTerminRepository.findById(terminId);
    }

    @Override
    public Termin save(Termin termin) {
        return jpaTerminRepository.save(termin);
    }

    @Override
    public void deleteById(Long terminId) {
        jpaTerminRepository.deleteById(terminId);
    }

    @Override
    public List<Termin> getAllTerminesByCarId(Long carId) {
        return jpaTerminRepository.findByCar_Id(carId);
    }

    @Override
    public void saveAll(List<Termin> termins) {
        jpaTerminRepository.saveAll(termins);
    }
}
