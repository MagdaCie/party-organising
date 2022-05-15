package pl.sda.partyorganising.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.partyorganising.entity.ParticipationEntity;

import java.util.UUID;

public interface ParticipationRepository extends JpaRepository<ParticipationEntity, UUID> {
}
