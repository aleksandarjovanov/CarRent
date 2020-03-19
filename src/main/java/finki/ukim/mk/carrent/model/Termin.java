package finki.ukim.mk.carrent.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Termin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate availableFrom;
    private LocalDate availableTo;

    @ManyToOne
    private Car car;

    public void createTermin(LocalDate from, LocalDate to, Car car){
        this.availableFrom = from;
        this.availableTo = to;
        this.car = car;
    }

}
