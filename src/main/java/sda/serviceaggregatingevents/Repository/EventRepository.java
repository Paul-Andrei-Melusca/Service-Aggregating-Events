package sda.serviceaggregatingevents.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import sda.serviceaggregatingevents.Entity.Event;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByUserId(Long userId);
}
