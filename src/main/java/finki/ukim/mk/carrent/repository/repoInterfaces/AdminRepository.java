package finki.ukim.mk.carrent.repository.repoInterfaces;

import finki.ukim.mk.carrent.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin,Long> {
    Optional<Admin> findById(Long adminId);

    Admin save(Admin admin);
}
