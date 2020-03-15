package finki.ukim.mk.carrent.repository.inMemory.impl;

import finki.ukim.mk.carrent.model.LocalData.InMemoryData;
import finki.ukim.mk.carrent.model.Termin;
import finki.ukim.mk.carrent.repository.inMemory.TerminRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class TerminRepoImpl implements TerminRepository {
    @Override
    public Optional<Termin> findById(int terminId) {
        return InMemoryData.termins.stream().filter(termin -> termin.getId() == terminId).findFirst();
    }

    @Override
    public Termin save(Termin termin) {
        this.findById(termin.getId()).ifPresent(termin1 -> InMemoryData.termins.remove(termin1));
        InMemoryData.termins.add(termin);
        return termin;
    }

    @Override
    public void deleteById(int terminId) {
        this.findById(terminId).ifPresent(termin -> InMemoryData.termins.remove(termin));
    }

    @Override
    public List<Termin> getTerminesByCarId(String carId) {
        return InMemoryData.termins.stream().filter(termin -> termin.getCar().getPlate().equals(carId)).collect(Collectors.toList());
    }

    @Override
    public void saveAll(List<Termin> termins) {
        InMemoryData.termins.addAll(termins);
    }
}
