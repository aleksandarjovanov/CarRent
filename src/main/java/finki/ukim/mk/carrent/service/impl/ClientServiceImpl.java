package finki.ukim.mk.carrent.service.impl;

import finki.ukim.mk.carrent.model.Client;
import finki.ukim.mk.carrent.model.Renter;
import finki.ukim.mk.carrent.model.Sex;
import finki.ukim.mk.carrent.model.exceptions.InvalidClientException;
import finki.ukim.mk.carrent.model.exceptions.InvalidRenterException;
import finki.ukim.mk.carrent.repository.jpa.JpaClientRepository;
import finki.ukim.mk.carrent.repository.repoInterfaces.ClientRepository;
import finki.ukim.mk.carrent.repository.repoInterfaces.RenterRepository;
import finki.ukim.mk.carrent.service.ClientService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;
    private RenterRepository renterRepository;

    public ClientServiceImpl(ClientRepository clientRepository, RenterRepository renterRepository) {
        this.clientRepository = clientRepository;
        this.renterRepository = renterRepository;
    }

    @Override
    public void follow(Long clientId, Long renterId) {
        Client client = this.clientRepository.findById(clientId).orElseThrow(InvalidClientException::new);
        Renter renter = this.renterRepository.findById(renterId).orElseThrow(InvalidRenterException::new);
        client.follow(renter);
        this.clientRepository.save(client);
        this.renterRepository.save(renter);
    }

    @Override
    public void unFollow(Long clientId, Long renterId) {
        Client client = this.clientRepository.findById(clientId).orElseThrow(InvalidClientException::new);
        Renter renter = this.renterRepository.findById(renterId).orElseThrow(InvalidRenterException::new);
        client.unFollow(renter);
        this.clientRepository.save(client);
        this.renterRepository.save(renter);
    }

    @Override
    public Client findById(Long clientId) {
        return this.clientRepository.findById(clientId).orElseThrow(InvalidClientException::new);
    }

    @Override
    public Client createClient(String embg, String name, int age, Sex sex, String driverLicenceNumber, boolean crimeRecord, String imgUrl) {
        Client client = new Client();
        client.createClient(embg, name, age, sex, driverLicenceNumber, crimeRecord, imgUrl);
        return this.clientRepository.save(client);
    }

    @Override
    public List<Client> getAllClients() {
        return this.clientRepository.getAllClients();
    }

    @Override
    public List<Client> searchClientsByName(String name) {
        return this.clientRepository.searchClientsByName(name);
    }

    @Override
    public void deleteById(Long clientId) {
        this.clientRepository.deleteById(clientId);
    }

    @Override
    public Client editClient(Long clientId, String embg, String name, int age, Sex sex, String driverLicenceNumber, boolean crimeRecord, String imgUrl) {
        Client client = findById(clientId);
        client.createClient(embg,name,age,sex,driverLicenceNumber,crimeRecord, imgUrl);
        return this.clientRepository.save(client);
    }
}
