package sda.serviceaggregatingevents.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sda.serviceaggregatingevents.Entity.Event;

public interface EventRepository extends JpaRepository<Event, Long> {
}
