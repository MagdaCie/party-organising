package pl.sda.partyorganising.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.sda.partyorganising.entity.*;

import java.sql.Date;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ParticipationRepositoryIT {

    @Autowired
    private ParticipationRepository participationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EventRepository eventRepository;

    @Test
    void shouldDoCrudOperations() {
        //given
        UserEntity userEntity = new UserEntity("testLogin", "testpassword", "test@test.com", "testNick", Set.of());
        userRepository.saveAndFlush(userEntity);
        EventEntity eventEntity = new EventEntity(Date.valueOf("2022-05-15"), "testEvent", "testAddress", AccessToEvent.PRIVATE, userEntity, Set.of());
        eventRepository.saveAndFlush(eventEntity);
        ParticipationEntity participationEntity = new ParticipationEntity(eventEntity, userEntity, ApprovalStatus.WaitingForResponse, ApprovalStatus.WaitingForResponse);
        //when
        participationRepository.saveAndFlush(participationEntity);
        Optional<ParticipationEntity> participationRepositoryFromDB = participationRepository.findById(participationEntity.getId());
        //then
        assertThat(participationRepositoryFromDB.isPresent()).isTrue();
        assertThat(participationRepositoryFromDB.get().getId()).isEqualTo(participationEntity.getId());
        assertThat(participationRepositoryFromDB.get().getOrganizerApprovalStatus()).isEqualTo(ApprovalStatus.WaitingForResponse);

        //given
        participationEntity.setOrganizerApprovalStatus(ApprovalStatus.Accepted);
        //when
        participationRepository.saveAndFlush(participationEntity);
        participationRepositoryFromDB = participationRepository.findById(participationEntity.getId());
        //then
        assertThat(participationRepositoryFromDB.isPresent()).isTrue();
        assertThat(participationRepositoryFromDB.get().getOrganizerApprovalStatus()).isEqualTo(ApprovalStatus.Accepted);

        //when
        participationRepository.delete(participationEntity);
        //then
        participationRepositoryFromDB = participationRepository.findById(participationEntity.getId());
        assertThat(participationRepositoryFromDB.isEmpty()).isTrue();
    }
}