package pl.sda.partyorganising.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.sda.partyorganising.entity.ParticipationEntity;
import pl.sda.partyorganising.entity.ParticipationStatus;
import pl.sda.partyorganising.entity.UserEntity;

import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ParticipationRepositoryIT {

    @Autowired
    private ParticipationRepository participationRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    void shouldDoCrudOperations() {
        //given
        UserEntity userEntity = new UserEntity("testLogin", "testpassword","test@test.com", "testNick", Set.of());
        userRepository.saveAndFlush(userEntity);
        ParticipationEntity participationEntity = new ParticipationEntity(userEntity, "testEventId", ParticipationStatus.WaitingForResponse);
        userEntity.setParticipations(Set.of(participationEntity));
        //when
        participationRepository.saveAndFlush(participationEntity);
        Optional<ParticipationEntity> participationRepositoryFromDB = participationRepository.findById(participationEntity.getId());
        //then
        assertThat(participationRepositoryFromDB.isPresent()).isTrue();
        assertThat(participationRepositoryFromDB.get()).usingRecursiveComparison().isEqualTo(participationEntity);

        //given
        participationEntity.setParticipationStatus(ParticipationStatus.Accepted);
        //when
        participationRepository.saveAndFlush(participationEntity);
        participationRepositoryFromDB=participationRepository.findById(participationEntity.getId());
        //then
        assertThat(participationRepositoryFromDB.isPresent()).isTrue();
        assertThat(participationRepositoryFromDB.get().getParticipationStatus()).isEqualTo(ParticipationStatus.Accepted);

        //when
        participationRepository.delete(participationEntity);
        //then
        participationRepositoryFromDB=participationRepository.findById(participationEntity.getId());
        assertThat(participationRepositoryFromDB.isEmpty()).isTrue();
    }
}