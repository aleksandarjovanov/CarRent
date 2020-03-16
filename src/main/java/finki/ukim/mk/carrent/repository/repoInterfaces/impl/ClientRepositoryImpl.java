package finki.ukim.mk.carrent.repository.repoInterfaces.impl;

import finki.ukim.mk.carrent.model.Client;
import finki.ukim.mk.carrent.repository.jpa.JpaClientRepository;
import finki.ukim.mk.carrent.repository.repoInterfaces.ClientRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepositoryImpl implements ClientRepository {

    private final JpaClientRepository jpaClientRepository;

    public ClientRepositoryImpl(JpaClientRepository jpaClientRepository) {
        this.jpaClientRepository = jpaClientRepository;
    }

    @Override
    public Optional<Client> findById(Long clientId) {
        return jpaClientRepository.findById(clientId);
    }

    @Override
    public Client save(Client client) {
        return jpaClientRepository.save(client);
    }

    @Override
    public List<Client> getAllClients() {
        return jpaClientRepository.findAll();
    }

    @Override
    public List<Client> searchClientsByName(String name) {
        return jpaClientRepository.searchClients(name);
    }

    @Override
    public void deleteById(Long clientId) {
        jpaClientRepository.deleteById(clientId);
    }
}
