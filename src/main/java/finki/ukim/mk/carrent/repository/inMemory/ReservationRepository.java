package finki.ukim.mk.carrent.repository.inMemory;

import finki.ukim.mk.carrent.model.Reservation;

import java.util.List;
import java.util.Optional;

public interface ReservationRepository {
    Optional<Reservation> findById(int reservationId);

    Reservation save(Reservation reservation);

    void deleteById(int reservationId);

    List<Reservation> getAllReservations();

    List<Reservation> getReservationsByClientId(String clientId);

    List<Reservation> getReservationsByRenterId(String renterId);


}
