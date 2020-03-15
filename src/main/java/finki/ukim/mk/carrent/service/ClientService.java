package finki.ukim.mk.carrent.service;

import finki.ukim.mk.carrent.model.Client;
import finki.ukim.mk.carrent.model.Sex;

import java.util.List;
import java.util.Optional;

public interface ClientService {

    void follow(String clientId, String renterId);

    void unFollow(String clientId, String renterId);

    Optional<Client> findById(String clientId);

    Client createClient(String clientId, String name, int age, Sex sex, String driverLicenceNumber, boolean crimeRecord);

    List<Client> getAllClients();

    List<Client> searchClientsByName(String name);

    void deleteById(String clientId);
}
