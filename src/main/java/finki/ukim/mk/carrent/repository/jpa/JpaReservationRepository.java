package finki.ukim.mk.carrent.repository.jpa;

import finki.ukim.mk.carrent.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface JpaReservationRepository extends JpaRepository<Reservation, Long> {

    @Query("select reservation from Reservation reservation join reservation.car car WHERE car.renter.id = :term")
    List<Reservation> findByRenter_Id(@Param("term") Long renter_Id);

    List<Reservation> findByClient_Id(Long client_Id);

    List<Reservation> findByClient_NameContaining(String name);

    List<Reservation> findReservationsByToIsGreaterThan(LocalDate now);
}
