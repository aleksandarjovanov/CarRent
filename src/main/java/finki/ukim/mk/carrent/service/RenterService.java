package finki.ukim.mk.carrent.service;

import finki.ukim.mk.carrent.model.Client;
import finki.ukim.mk.carrent.model.Renter;
import finki.ukim.mk.carrent.model.Sex;

import java.util.List;
import java.util.Optional;

public interface RenterService {

    List<Client> getFollowers(Long renterId);

    Renter findById(Long renterId);

    Renter createRenter(String embg, String firstName, String lastName, int age, Sex sex, String imgUrl, List<Client> followersList);

    List<Renter> getAllRenters();

    List<Renter> searchRenters(String name);

    void deleteById(Long renterId);

    Renter editRenter(Long renterId, String embg, String firstName, String lastName, int age, Sex sex, String imgUrl);
}
