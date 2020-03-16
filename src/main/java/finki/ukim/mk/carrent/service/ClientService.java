package finki.ukim.mk.carrent.service;

import finki.ukim.mk.carrent.model.Client;
import finki.ukim.mk.carrent.model.Sex;

import java.util.List;
import java.util.Optional;

public interface ClientService {

    void follow(Long clientId, Long renterId);

    void unFollow(Long clientId, Long renterId);

    Optional<Client> findById(Long clientId);

    Client createClient(Long clientId, String name, int age, Sex sex, String driverLicenceNumber, boolean crimeRecord);

    List<Client> getAllClients();

    List<Client> searchClientsByName(String name);

    void deleteById(Long clientId);
}
