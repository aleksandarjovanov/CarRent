package finki.ukim.mk.carrent.model.combinedResult;

import finki.ukim.mk.carrent.model.Car;
import finki.ukim.mk.carrent.model.Termin;

import java.util.List;

public class CarAndTerminesCombined {
    private Car car;
    private List<Termin> termins;

    public CarAndTerminesCombined(Car car, List<Termin> termins) {
        this.car = car;
        this.termins = termins;
    }
}
