package sda.serviceaggregatingevents.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sda.serviceaggregatingevents.Entity.Event;

import java.time.LocalDateTime;
import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByTitleContainingIgnoreCase(String keyword);
    List<Event> findByStartTimeAfter(LocalDateTime dateTime);
    List<Event> findByStartTimeBetween(LocalDateTime from, LocalDateTime to);
}