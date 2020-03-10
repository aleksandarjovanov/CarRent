package finki.ukim.mk.carrent.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Reservation {

    private Long id;
    private String comment;

    private Client client;
    private Renter renter;
    private Car car;
}
