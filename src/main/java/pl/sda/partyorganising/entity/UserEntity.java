package pl.sda.partyorganising.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
    @Column(unique = true)
    private String email;
    private String nickName;
}
