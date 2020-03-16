package finki.ukim.mk.carrent.repository.repoInterfaces.impl;

import finki.ukim.mk.carrent.model.Client;
import finki.ukim.mk.carrent.model.Renter;
import finki.ukim.mk.carrent.repository.jpa.JpaRenterRepository;
import finki.ukim.mk.carrent.repository.repoInterfaces.RenterRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RenterRepositoryImpl implements RenterRepository {

    private final JpaRenterRepository jpaRenterRepository;

    public RenterRepositoryImpl(JpaRenterRepository jpaRenterRepository) {
        this.jpaRenterRepository = jpaRenterRepository;
    }

    @Override
    public Optional<Renter> findById(Long renterId) {
        return jpaRenterRepository.findById(renterId);
    }

    @Override
    public Renter save(Renter renter) {
        return jpaRenterRepository.save(renter);
    }

    @Override
    public List<Renter> getAllRenters() {
        return jpaRenterRepository.findAll();
    }

    @Override
    public List<Renter> searchRenters(String name) {
        return jpaRenterRepository.searchRenters(name);
    }

    @Override
    public void deleteById(Long renterId) {
        jpaRenterRepository.deleteById(renterId);
    }

}
