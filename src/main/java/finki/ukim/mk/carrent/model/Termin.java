package finki.ukim.mk.carrent.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.Month;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Termin {

    private Long id;

    private LocalDate availableFrom;
    private LocalDate availableTo;
    private Car car;
}
