package finki.ukim.mk.carrent.service.impl;

import finki.ukim.mk.carrent.model.Car;
import finki.ukim.mk.carrent.model.Client;
import finki.ukim.mk.carrent.model.Renter;
import finki.ukim.mk.carrent.model.Sex;
import finki.ukim.mk.carrent.model.exceptions.InvalidRenterException;
import finki.ukim.mk.carrent.repository.repoInterfaces.CarRepository;
import finki.ukim.mk.carrent.repository.repoInterfaces.RenterRepository;
import finki.ukim.mk.carrent.service.CarService;
import finki.ukim.mk.carrent.service.RenterService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RenterServiceImpl implements RenterService {

    private final RenterRepository renterRepository;
    private final CarService carService;

    public RenterServiceImpl(RenterRepository renterRepository, CarService carService) {
        this.renterRepository = renterRepository;
        this.carService = carService;
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
    public Renter createRenter(String embg, String firstName, String lastName, int age, Sex sex, String imgUrl, List<Client> followersList) {
        Renter renter = new Renter();
        renter.createRenter(embg, firstName, lastName, age, sex, imgUrl, followersList);
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
        List<Car> cars = this.carService.getAllOwnedCarsById(renterId);
        cars.forEach(car -> this.carService.deleteById(car.getId()));
        this.renterRepository.deleteById(renterId);
    }

    @Override
    public Renter editRenter(Long renterId, String embg, String firstName, String lastName, int age, Sex sex, String imgUrl) {
        Renter renter = findById(renterId);
        renter.createRenter(embg, firstName, lastName, age, sex, imgUrl, renter.getFollowers());
        return this.renterRepository.save(renter);
    }
}
