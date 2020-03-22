package finki.ukim.mk.carrent.repository.repoInterfaces.impl;

import finki.ukim.mk.carrent.model.Reservation;
import finki.ukim.mk.carrent.repository.jpa.JpaReservationRepository;
import finki.ukim.mk.carrent.repository.repoInterfaces.ReservationRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepositoryImpl implements ReservationRepository {

    private final JpaReservationRepository jpaReservationRepository;

    public ReservationRepositoryImpl(JpaReservationRepository jpaReservationRepository) {
        this.jpaReservationRepository = jpaReservationRepository;
    }

    @Override
    public Optional<Reservation> findById(Long reservationId) {
        return jpaReservationRepository.findById(reservationId);
    }

    @Override
    public Reservation save(Reservation reservation) {
        return jpaReservationRepository.save(reservation);
    }

    @Override
    public void deleteById(Long reservationId) {
        jpaReservationRepository.deleteById(reservationId);
    }

    @Override
    public List<Reservation> getAllReservations() {
        return jpaReservationRepository.findAll();
    }

    @Override
    public List<Reservation> getReservationsByClientId(Long clientId) {
        return jpaReservationRepository.findByClient_Id(clientId);
    }

    @Override
    public List<Reservation> getReservationsByRenterId(Long renterId) {
        return jpaReservationRepository.findByRenter_Id(renterId);
    }

    @Override
    public List<Reservation> getReservationsByClientName(String name) {
        return this.jpaReservationRepository.findByClientName(name);
    }

    @Override
    public List<Reservation> getActiveReservations(LocalDate now) {
        return this.jpaReservationRepository.findReservationsByToIsLessThan(now);
    }

}
