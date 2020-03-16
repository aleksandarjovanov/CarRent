package finki.ukim.mk.carrent.repository.jpa;

import finki.ukim.mk.carrent.model.Termin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaTerminRepository extends JpaRepository<Termin, Long> {
}
