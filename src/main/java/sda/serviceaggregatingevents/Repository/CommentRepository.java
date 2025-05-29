package sda.serviceaggregatingevents.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sda.serviceaggregatingevents.Entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
