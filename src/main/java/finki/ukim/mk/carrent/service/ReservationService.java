package finki.ukim.mk.carrent.service;

import finki.ukim.mk.carrent.model.Car;
import finki.ukim.mk.carrent.model.Client;
import finki.ukim.mk.carrent.model.Reservation;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ReservationService {
    Optional<Reservation> findById(int reservationId);

    Reservation createReservation(String clientId, String carId, String comment, LocalDate from, LocalDate to); // this method will call createReservation() in the model!

    void deleteById(int reservationId);

    List<Reservation> getAllReservations();

    List<Reservation> getReservationsByClientId(String clientId);

    List<Reservation> getReservationsByRenterId(String renterId);
}
