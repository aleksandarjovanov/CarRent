package finki.ukim.mk.carrent.repository.inMemory;

import finki.ukim.mk.carrent.model.Car;
import finki.ukim.mk.carrent.model.Client;
import finki.ukim.mk.carrent.model.Renter;

import java.util.List;
import java.util.Optional;

public interface RenterRepository {

    Optional<Renter> findById(String renterId);

    Renter save(Renter renter);

    List<Renter> getAllRenters();// if admin wants to see all renters, to ban someone or etc...

    List<Renter> searchRenters(String name);

    void deleteById(String renterId);

    List<Client> getAllFollowers(String renterId);
}