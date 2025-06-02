package sda.serviceaggregatingevents.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sda.serviceaggregatingevents.Entity.Event;
import sda.serviceaggregatingevents.service.EventService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/events")
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    @PostMapping
    public ResponseEntity<Event> createEvent(@RequestBody Event event) {
        return ResponseEntity.ok(eventService.createEvent(event));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable Long id, @RequestBody Event event) {
        return ResponseEntity.ok(eventService.updateEvent(id, event));
    }

    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable Long id) {
        return eventService.getEventById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public List<Event> search(@RequestParam Optional<String> title) {
        return title.map(eventService::searchByTitle).orElse(eventService.getAllEvents());
    }

    @GetMapping("/future")
    public List<Event> getFutureEvents() {
        return eventService.getFutureEvents();
    }

    @GetMapping("/range")
    public List<Event> getEventsInRange(@RequestParam String start, @RequestParam String end) {
        return eventService.getEventsBetween(
                LocalDateTime.parse(start), LocalDateTime.parse(end));
    }
}