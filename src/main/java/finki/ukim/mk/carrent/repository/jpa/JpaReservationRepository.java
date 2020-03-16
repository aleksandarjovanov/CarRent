package finki.ukim.mk.carrent.repository.jpa;

import finki.ukim.mk.carrent.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaReservationRepository extends JpaRepository<Reservation, Long> {
}
