package finki.ukim.mk.carrent.repository.inMemory.impl;

import finki.ukim.mk.carrent.model.Car;
import finki.ukim.mk.carrent.model.Client;
import finki.ukim.mk.carrent.model.LocalData.InMemoryData;
import finki.ukim.mk.carrent.repository.inMemory.CarRepository;
import finki.ukim.mk.carrent.repository.inMemory.ClientRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ClientRepoImpl implements ClientRepository {
    @Override
    public Optional<Client> findById(String clientId) {
        return InMemoryData.clients.stream().filter(client -> client.getEmbg().equals(clientId)).findFirst();
    }

    @Override
    public Client save(Client client) {
        this.findById(client.getEmbg()).ifPresent(client1 -> InMemoryData.clients.remove(client1));
        InMemoryData.clients.add(client);
        return client;
    }

    @Override
    public List<Client> getAllClients() {
        return InMemoryData.clients;
    }

    @Override
    public List<Client> searchClientsByName(String name) {
        return InMemoryData.clients.stream().filter(client -> client.getName().equals(name)).collect(Collectors.toList());
    }

    @Override
    public void deleteById(String clientId) {
        this.findById(clientId).ifPresent(client1 -> InMemoryData.clients.remove(client1));
    }
}
