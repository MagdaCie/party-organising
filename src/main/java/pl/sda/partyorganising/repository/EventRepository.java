package pl.sda.partyorganising.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.partyorganising.entity.EventEntity;

import java.util.UUID;

public interface EventRepository extends JpaRepository<EventEntity, UUID> {
}
