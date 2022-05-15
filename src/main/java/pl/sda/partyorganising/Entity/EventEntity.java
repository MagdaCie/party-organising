package pl.sda.partyorganising.Entity;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

import static pl.sda.partyorganising.Entity.ParticipationStatusEnum.ACCEPTED;

@Entity(name = "Event")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter


public class EventEntity {
    @Id
    @Type(type = "uuid-char")
    private final UUID id = UUID.randomUUID();
    @Column(unique = true)
    private String name;
    private String addres;
    @Enumerated(EnumType.ORDINAL)
    private AcessToEvent acessToEvent;

    @OneToMany(mappedBy = "UserEntity_id")
    public Set<UserEntity> organizators;
    @OneToMany(mappedBy = "UserEntity_id" && ACCEPTED)
    public Set<UserEntity> participants;
}
