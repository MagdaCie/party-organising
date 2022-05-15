package pl.sda.partyorganising.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.partyorganising.Entity.Comment;
import pl.sda.partyorganising.Entity.Event;

import java.util.List;

public interface EventRepository extends JpaRepository <Event, Long> {
    List<Comment> findEventByComment(Comment comment)
}
