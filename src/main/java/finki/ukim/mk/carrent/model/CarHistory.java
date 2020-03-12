package finki.ukim.mk.carrent.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CarHistory {

    private int id;
    private LocalDate registrationDate;
    private String breaksStatus;
    private String frontGlassStatus;
    private String wheelsStatus;
    private String engineStatus;
    private int kmDistancePassed;
    private String detailsDescription;

    private Car car;
}
