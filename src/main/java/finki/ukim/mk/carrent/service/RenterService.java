package finki.ukim.mk.carrent.service;

import finki.ukim.mk.carrent.model.Client;
import finki.ukim.mk.carrent.model.Renter;
import finki.ukim.mk.carrent.model.Sex;

import java.util.List;
import java.util.Optional;

public interface RenterService {

    List<Client> getFollowers(Long renterId);

    Optional<Renter> findById(Long renterId);

    Renter createRenter(Long renterId, String name, int age, Sex sex);

    List<Renter> getAllRenters();

    List<Renter> searchRenters(String name);

    void deleteById(Long renterId);

}
