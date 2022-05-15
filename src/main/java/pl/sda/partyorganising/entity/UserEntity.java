package pl.sda.partyorganising.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity(name = "User")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    @Type(type = "uuid-char")
    private final UUID id = UUID.randomUUID();

    @Column(unique = true)
    private String login;

    private String password;

    @Column(unique = true)
    private String email;

    private String nickName;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Set<ParticipationEntity> participations;
}
