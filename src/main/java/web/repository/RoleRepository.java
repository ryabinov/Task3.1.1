package web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.models.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByname(String name);
}
