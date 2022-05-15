package pl.sda.partyorganising.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "Participation")
public class ParticipationEntity {
    @Id
    @Type(type = "uuid-char")
    private final UUID id = UUID.randomUUID();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "event_id")
    private EventEntity event;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "participant_id")
    private UserEntity participant;

    private ApprovalStatus organizerApprovalStatus;

    private ApprovalStatus participantApprovalStatus
}
