package finki.ukim.mk.carrent.repository;

import finki.ukim.mk.carrent.model.Client;

import java.util.List;
import java.util.Optional;

public interface ClientRepository {

    Optional<Client> findById(String embg);
    void save(Client client);
    List<Client> getAllClients(); // if admin wants to see all clients, to ban someone or etc...
    List<Client> searchClients(String name);
}
