package finki.ukim.mk.carrent.repository.repoInterfaces;

import java.util.Optional;

import finki.ukim.mk.carrent.model.ERole;
import finki.ukim.mk.carrent.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}