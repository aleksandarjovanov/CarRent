package finki.ukim.mk.carrent.repository.jpa;

import finki.ukim.mk.carrent.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JpaClientRepository extends JpaRepository<Client,Long> {

    @Query("select c from Client c " +
            "WHERE c.name like :term")
    List<Client> searchClients(@Param("term") String term);
}
