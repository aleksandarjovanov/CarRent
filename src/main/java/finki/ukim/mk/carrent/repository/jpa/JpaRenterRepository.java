package finki.ukim.mk.carrent.repository.jpa;

import finki.ukim.mk.carrent.model.Client;
import finki.ukim.mk.carrent.model.Renter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JpaRenterRepository extends JpaRepository<Renter, Long> {
    @Query("select r from Renter r " +
            "WHERE r.name like :term")
    List<Renter> searchRenters(@Param("term") String term);
}
