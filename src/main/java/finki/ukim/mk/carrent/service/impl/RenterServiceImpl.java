package finki.ukim.mk.carrent.service.impl;

import finki.ukim.mk.carrent.model.Client;
import finki.ukim.mk.carrent.model.Renter;
import finki.ukim.mk.carrent.model.Sex;
import finki.ukim.mk.carrent.model.exceptions.InvalidRenterException;
import finki.ukim.mk.carrent.repository.repoInterfaces.RenterRepository;
import finki.ukim.mk.carrent.service.RenterService;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RenterServiceImpl implements RenterService {

    private final RenterRepository renterRepository;

    public RenterServiceImpl(RenterRepository renterRepository) {
        this.renterRepository = renterRepository;
    }

    @Override
    public List<Client> getFollowers(Long renterId) {
        Renter renter = this.renterRepository.findById(renterId).orElseThrow(InvalidRenterException::new);
        return renter.getFollowers();
    }

    @Override
    public Renter findById(Long renterId) {
        return this.renterRepository.findById(renterId).orElseThrow(InvalidRenterException::new);
    }

    @Override
    public Renter createRenter(String embg, String name, int age, Sex sex) {
        Renter renter = new Renter();
        renter.createRenter(embg, name, age, sex);
        return this.renterRepository.save(renter);
    }

    @Override
    public List<Renter> getAllRenters() {
        return this.renterRepository.getAllRenters();
    }

    @Override
    public List<Renter> searchRenters(String name) {
        return this.renterRepository.searchRenters(name);
    }

    @Override
    public void deleteById(Long renterId) {
        this.renterRepository.deleteById(renterId);
    }
}
