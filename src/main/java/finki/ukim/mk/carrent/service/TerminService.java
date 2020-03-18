package finki.ukim.mk.carrent.service;

import finki.ukim.mk.carrent.model.Car;
import finki.ukim.mk.carrent.model.Termin;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface TerminService {
    Termin findById(Long terminId);

    Termin createTermin(LocalDate from, LocalDate to, Long carId);

    void deleteById(Long terminId);

    List<Termin> getTerminesByCarId(Long carId);

    void checkTerminChanges(Long carId);

    void calculateNewTermines(Long carId, LocalDate from, LocalDate to);
}
