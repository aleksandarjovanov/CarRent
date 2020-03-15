package finki.ukim.mk.carrent.repository.inMemory.impl;

import finki.ukim.mk.carrent.model.Client;
import finki.ukim.mk.carrent.model.LocalData.InMemoryData;
import finki.ukim.mk.carrent.model.Renter;
import finki.ukim.mk.carrent.repository.inMemory.RenterRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class RenterRepoImpl implements RenterRepository {
    @Override
    public Optional<Renter> findById(String renterId) {
        return InMemoryData.renters.stream().filter(renter -> renter.getEmbg().equals(renterId)).findFirst();
    }

    @Override
    public Renter save(Renter renter) {
        this.findById(renter.getEmbg()).ifPresent(renter1 -> InMemoryData.renters.remove(renter1));
        InMemoryData.renters.add(renter);
        return renter;
    }

    @Override
    public List<Renter> getAllRenters() {
        return InMemoryData.renters;
    }

    @Override
    public List<Renter> searchRenters(String name) {
        return InMemoryData.renters.stream().filter(renter -> renter.getName().equals(name)).collect(Collectors.toList());
    }

    @Override
    public void deleteById(String renterId) {
        this.findById(renterId).ifPresent(renter1 -> InMemoryData.renters.remove(renter1));
    }

    @Override
    public List<Client> getAllFollowers(String renterId) {
        return this.findById(renterId).orElse(new Renter()).getFollowers();
    }
}
