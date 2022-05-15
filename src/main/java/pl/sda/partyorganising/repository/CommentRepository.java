package pl.sda.partyorganising.repository;

import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.partyorganising.Entity.Comment;
import pl.sda.partyorganising.Entity.Event;
import pl.sda.partyorganising.Entity.User;

import java.util.List;
import java.util.Optional;


public interface CommentRepository extends JpaRepository<Comment,Long> {
    List<Comment> findCommentByUserId(User user);
}
