package finki.ukim.mk.carrent.model;

import lombok.*;

import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Reservation {

    private Long id;
    private String comment;
    //@Column(name = "from_time")
    private LocalDate from;

    //@Column(name = "to_time")
    private LocalDate to;

    private Client client;
    private Car car;

    public void createReservation(Client client, Car car, String comment, LocalDate from, LocalDate to){
        this.client = client;
        this.car = car;
        this.comment = comment;
        this.from = from;
        this.to = to;
    }
}
