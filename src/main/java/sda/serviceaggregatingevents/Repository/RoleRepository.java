package sda.serviceaggregatingevents.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sda.serviceaggregatingevents.Entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
