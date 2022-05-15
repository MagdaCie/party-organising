package pl.sda.partyorganising.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;
import java.util.UUID;

@Entity(name = "Event")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EventEntity {
    @Id
    @Type(type = "uuid-char")
    private final UUID id = UUID.randomUUID();

    private Date date;

    @Column(unique = true)
    private String name;

    private String address;

    @Enumerated(EnumType.STRING)
    private AccessToEvent accessToEvent;

    @ManyToOne(fetch = FetchType.EAGER)
    private UserEntity organizer;

    @OneToMany(mappedBy = "participant", fetch = FetchType.EAGER)
    private Set<ParticipationEntity> participations;
}
