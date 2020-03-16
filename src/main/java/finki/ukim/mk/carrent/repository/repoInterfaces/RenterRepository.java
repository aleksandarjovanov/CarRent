package finki.ukim.mk.carrent.repository.repoInterfaces;

import finki.ukim.mk.carrent.model.Client;
import finki.ukim.mk.carrent.model.Renter;

import java.util.List;
import java.util.Optional;

public interface RenterRepository {

    Optional<Renter> findById(Long renterId);

    Renter save(Renter renter);

    List<Renter> getAllRenters();// if admin wants to see all renters, to ban someone or etc...

    List<Renter> searchRenters(String name);

    void deleteById(Long renterId);

}