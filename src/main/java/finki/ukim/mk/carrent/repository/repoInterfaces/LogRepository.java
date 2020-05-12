package finki.ukim.mk.carrent.repository.repoInterfaces;

import finki.ukim.mk.carrent.model.Client;
import finki.ukim.mk.carrent.model.Log;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LogRepository extends JpaRepository<Log, Long> {
    Optional<Log> findById(Long logId);

    Log save(Log log);

    List<Log> findAll();
}
