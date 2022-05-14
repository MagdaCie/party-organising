package pl.sda.partyorganising.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

public class Comment {

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id", referencedColumnName = "id")
    private Event event;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="user_id", referencedColumnName = "id")
    private User user;

}
