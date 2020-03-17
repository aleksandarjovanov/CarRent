package finki.ukim.mk.carrent.repository.jpa;

import finki.ukim.mk.carrent.model.CarHistory;
import finki.ukim.mk.carrent.model.Termin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaTerminRepository extends JpaRepository<Termin, Long> {

    List<Termin> findByCar_Id(Long car_Id);
}
