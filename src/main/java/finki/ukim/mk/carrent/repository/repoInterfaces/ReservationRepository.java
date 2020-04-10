package finki.ukim.mk.carrent.repository.repoInterfaces;

import finki.ukim.mk.carrent.model.Reservation;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ReservationRepository {
    Optional<Reservation> findById(Long reservationId);

    Reservation save(Reservation reservation);

    void deleteById(Long reservationId);

    List<Reservation> getAllReservations();

    List<Reservation> getReservationsByClientId(Long clientId);

    List<Reservation> getReservationsByRenterId(Long renterId);

    List<Reservation> getReservationsByClientName(String name);

    List<Reservation> getActiveReservations(LocalDate now);

    List<Reservation> getReservationsByCarId(Long carId);

    void deleteAll(List<Reservation> reservations);
}
