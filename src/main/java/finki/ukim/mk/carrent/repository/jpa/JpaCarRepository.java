package finki.ukim.mk.carrent.repository.jpa;

import finki.ukim.mk.carrent.model.Car;
import finki.ukim.mk.carrent.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JpaCarRepository extends JpaRepository<Car,Long> {

    List<Car> findByMarkContaining(String mark);

    List<Car> findByRenter_Id(Long renter_Id);

}
