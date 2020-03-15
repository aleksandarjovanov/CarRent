package finki.ukim.mk.carrent.repository.inMemory.impl;

import finki.ukim.mk.carrent.model.LocalData.InMemoryData;
import finki.ukim.mk.carrent.model.Reservation;
import finki.ukim.mk.carrent.repository.inMemory.ReservationRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ReservationRepoImpl implements ReservationRepository {
    @Override
    public Optional<Reservation> findById(int reservationId) {
        return InMemoryData.reservations.stream().filter(reservation -> reservation.getReservationId() == reservationId).findFirst();
    }

    @Override
    public Reservation save(Reservation reservation) {
        this.findById(reservation.getReservationId()).ifPresent(reservation1 -> InMemoryData.reservations.remove(reservation1));
        InMemoryData.reservations.add(reservation);
        return reservation;
    }

    @Override
    public void deleteById(int reservationId) {
        this.findById(reservationId).ifPresent(reservation -> InMemoryData.reservations.remove(reservation));
    }

    @Override
    public List<Reservation> getAllReservations() {
        return InMemoryData.reservations;
    }

    @Override
    public List<Reservation> getReservationsByClientId(String clientId) {
        return InMemoryData.reservations.stream().filter(reservation -> reservation.getClient().getEmbg().equals(clientId)).collect(Collectors.toList());
    }

    @Override
    public List<Reservation> getReservationsByRenterId(String renterId) {
        return InMemoryData.reservations.stream().filter(reservation -> reservation.getCar().getRenter().getEmbg().equals(renterId)).collect(Collectors.toList());
    }
}
