package sda.serviceaggregatingevents.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sda.serviceaggregatingevents.Entity.Comment;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByEventIdOrderByCreatedAtDesc(Long eventId);

    List<Comment> findByEventIdOrderByIdDesc(Long eventId);
}