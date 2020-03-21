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
    public Termin createTermin(LocalDate from, LocalDate to, Long carId) {
        Termin termin = new Termin();
        termin.createTermin(from, to, this.carRepository.findById(carId).orElseThrow(InvalidCarException::new));
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
    public void checkTerminChanges(Long carId) {                          // This will be called from CarServiceImpl.findById()
        List<Termin> terminList = getTerminesByCarId(carId);

        for(Termin t : terminList){
            if(t.getAvailableFrom().compareTo(LocalDate.now()) < 0){       // The Termin have new time AvailableFrom ? If yes then make changes to db!
                t.setAvailableFrom(LocalDate.now());
                if(t.getAvailableTo().compareTo(t.getAvailableFrom()) <= 0){    // The time for the Termin passed ? If yes delete it!
                    deleteById(t.getId());
                }
                else{
                    this.terminRepository.save(t);                              // If not save the termin with his new AvailableFrom !
                }
            }
        }
    }

    @Override
    public void calculateNewTermines(Long carId, LocalDate from, LocalDate to) {                  // This will be called from ReservationServiceImpl.createReservation()
        List<Termin> terminList = getTerminesByCarId(carId);
        for(Termin t : terminList){
            if((from.compareTo(t.getAvailableFrom()) >= 0) && (to.compareTo(t.getAvailableTo()) <= 0)){
                deleteById(t.getId());
                if((from.compareTo(t.getAvailableFrom()) == 0) && (to.compareTo(t.getAvailableTo()) < 0)){
                    createTermin(to, t.getAvailableTo(), carId);
                }
                else if((from.compareTo(t.getAvailableFrom()) > 0) && (to.compareTo(t.getAvailableTo()) == 0)){
                    createTermin(t.getAvailableFrom(), from, carId);
                }
                else {
                    createTermin(t.getAvailableFrom(), from, carId);
                    createTermin(to, t.getAvailableTo(), carId);
                }
            }
            break;
        }
    }
}
