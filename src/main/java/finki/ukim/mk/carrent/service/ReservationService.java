package finki.ukim.mk.carrent.service;

import finki.ukim.mk.carrent.model.Car;
import finki.ukim.mk.carrent.model.Client;
import finki.ukim.mk.carrent.model.Reservation;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ReservationService {
    Reservation findById(Long reservationId);

    Reservation createReservation(Long clientId, Long carId, String comment, LocalDate from, LocalDate to); // this method will call createReservation() in the model!

    void deleteById(Long reservationId);

    List<Reservation> getAllReservations();

    List<Reservation> getReservationsByClientId(Long clientId);

    List<Reservation> getReservationsByRenterId(Long renterId);

    List<Reservation> getReservationsByClientName(String name);

    List<Reservation> getActiveReservations(LocalDate now);
}
