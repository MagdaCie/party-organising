package pl.sda.partyorganising.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.partyorganising.entity.UserEntity;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
}
