package pl.sda.partyorganising.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.partyorganising.entity.CommentEntity;

import java.util.UUID;

public interface CommentRepository extends JpaRepository<CommentEntity, UUID> {
}
