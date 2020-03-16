package finki.ukim.mk.carrent.repository.jpa;

import finki.ukim.mk.carrent.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCarRepository extends JpaRepository<Car,Long> {
}
