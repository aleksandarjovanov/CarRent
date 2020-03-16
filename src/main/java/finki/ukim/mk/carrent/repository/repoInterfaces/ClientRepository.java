package finki.ukim.mk.carrent.repository.repoInterfaces;

import finki.ukim.mk.carrent.model.Client;

import java.util.List;
import java.util.Optional;

public interface ClientRepository {

    Optional<Client> findById(Long clientId);

    Client save(Client client);

    List<Client> getAllClients(); // if admin wants to see all clients, to ban someone or etc...

    List<Client> searchClientsByName(String name);

    void deleteById(Long clientId);
}
