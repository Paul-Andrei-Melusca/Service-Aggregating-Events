package sda.serviceaggregatingevents.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sda.serviceaggregatingevents.Entity.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);

}