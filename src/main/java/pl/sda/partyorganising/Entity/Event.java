package pl.sda.partyorganising.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity (name ="Event")
@NoArgsConstructor
@AllArgsConstructor


public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private String name;
    private String addres;
    @Enumerated(EnumType.ORDINAL)
    private AcessToEvent acessToEvent;
    public List<User> organizators;
    public List<User> users;
}
