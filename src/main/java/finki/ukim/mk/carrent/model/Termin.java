package finki.ukim.mk.carrent.model;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Termin {


    private Long id;
    private LocalDate availableFrom;
    private LocalDate availableTo;
    private Car car;

    public void createTermin(LocalDate from, LocalDate to, Car car){
        this.availableFrom = from;
        this.availableTo = to;
        this.car = car;
    }

}
