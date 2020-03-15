package finki.ukim.mk.carrent.repository.inMemory;

import finki.ukim.mk.carrent.model.Termin;

import java.util.List;
import java.util.Optional;

public interface TerminRepository {

    Optional<Termin> findById(int terminId);

    Termin save(Termin termin);

    void deleteById(int terminId);

    List<Termin> getTerminesByCarId(String carId);

    void saveAll(List<Termin> termins); // It will save a list of termines in Termin table DB, the whole logic of calculating new termines will be in Service layer!
}
