package finki.ukim.mk.carrent.model;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Reservation {


    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private static int reservationCounter = 1;

    private int reservationId;
    private String comment;
    //@Column(name = "from_time")
    private LocalDate from;

    //@Column(name = "to_time")
    private LocalDate to;

    private Client client;
    private Renter renter;
    private Car car;

    public static Reservation createReservation(Client client, Renter renter, Car car, String comment, LocalDate from, LocalDate to){
        Reservation reservation = new Reservation();
        reservation.reservationId = reservationCounter;
        reservationCounter++;
        reservation.client = client;
        reservation.renter = renter;
        reservation.car = car;
        reservation.comment = comment;
        reservation.from = from;
        reservation.to = to;

        return reservation;
    }
}
