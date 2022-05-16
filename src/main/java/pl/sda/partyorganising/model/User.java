package pl.sda.partyorganising.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor
@Getter
public class User {
    private final UUID id = UUID.randomUUID();
    private String login;
    private String password;
    private String email;
    private String nickName;
}
