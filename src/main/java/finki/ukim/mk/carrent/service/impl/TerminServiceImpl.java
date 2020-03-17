package finki.ukim.mk.carrent.service.impl;

import finki.ukim.mk.carrent.model.Car;
import finki.ukim.mk.carrent.model.Termin;
import finki.ukim.mk.carrent.model.exceptions.InvalidCarException;
import finki.ukim.mk.carrent.model.exceptions.InvalidTerminException;
import finki.ukim.mk.carrent.repository.repoInterfaces.CarRepository;
import finki.ukim.mk.carrent.repository.repoInterfaces.TerminRepository;
import finki.ukim.mk.carrent.service.TerminService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TerminServiceImpl implements TerminService {

    private final TerminRepository terminRepository;
    private final CarRepository carRepository;

    public TerminServiceImpl(TerminRepository terminRepository, CarRepository carRepository) {
        this.terminRepository = terminRepository;
        this.carRepository = carRepository;
    }

    @Override
    public Termin findById(Long terminId) {
        return this.terminRepository.findById(terminId).orElseThrow(InvalidTerminException::new);
    }

    @Override
    public Termin createTermin(LocalDate from, LocalDate to, Car car) {
        Termin termin = new Termin();
        termin.createTermin(from, to, car);
        return this.terminRepository.save(termin);
    }

    @Override
    public void deleteById(Long terminId) {
        this.terminRepository.deleteById(terminId);
    }

    @Override
    public List<Termin> getTerminesByCarId(Long carId) {
        return this.terminRepository.getAllTerminesByCarId(carId);
    }

    @Override
    public void calculateNewTermines(Long carId) {
        // This will be called from CarServiceImpl.findById()
        List<Termin> terminList = getTerminesByCarId(carId);

        Termin tempTermin = terminList.get(0);
        tempTermin.setAvailableFrom(LocalDate.now());
        this.terminRepository.save(tempTermin);

        // TUKA SUM ZASTANAT !!!!

    }
}
