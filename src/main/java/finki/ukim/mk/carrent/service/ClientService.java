package finki.ukim.mk.carrent.service;

import finki.ukim.mk.carrent.model.Client;
import finki.ukim.mk.carrent.model.Renter;
import finki.ukim.mk.carrent.model.Sex;

import java.util.List;
import java.util.Optional;

public interface ClientService {

    void follow(Long clientId, Long renterId);

    void unFollow(Long clientId, Long renterId);

    Client findById(Long clientId);

    Client createClient(Long id, String embg, String firstName, String lastName, int age, Sex sex, String driverLicenceNumber, boolean crimeRecord, String imgUrl);

    List<Client> getAllClients();

    List<Client> searchClientsByName(String name);

    void deleteById(Long clientId);

    Client editClient(Long clientId, String embg, String firstName, String lastName, int age, Sex sex, String driverLicenceNumber, boolean crimeRecord, String imgUrl);

    List<Renter> getFollowing(Long clientId);
}
