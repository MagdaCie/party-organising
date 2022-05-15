package pl.sda.partyorganising.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;
@Entity
@JsonIgnoreProperties
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentEntity {

    @Id
    @Type(type = "uuid-char")
    private final UUID id = UUID.randomUUID();

    public String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id", referencedColumnName = "id")
    private EventEntity eventEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity user;

}
