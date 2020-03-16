package finki.ukim.mk.carrent.service.impl;

import finki.ukim.mk.carrent.model.Client;
import finki.ukim.mk.carrent.model.Sex;
import finki.ukim.mk.carrent.repository.jpa.JpaClientRepository;
import finki.ukim.mk.carrent.repository.repoInterfaces.ClientRepository;
import finki.ukim.mk.carrent.service.ClientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public void follow(Long clientId, Long renterId) {

    }

    @Override
    public void unFollow(Long clientId, Long renterId) {

    }

    @Override
    public Optional<Client> findById(Long clientId) {
        return Optional.empty();
    }

    @Override
    public Client createClient(Long clientId, String name, int age, Sex sex, String driverLicenceNumber, boolean crimeRecord) {
        return null;
    }

    @Override
    public List<Client> getAllClients() {
        return null;
    }

    @Override
    public List<Client> searchClientsByName(String name) {
        return null;
    }

    @Override
    public void deleteById(Long clientId) {

    }
}
