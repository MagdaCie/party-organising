package pl.sda.partyorganising.model;

import lombok.Getter;
import pl.sda.partyorganising.entity.AccessToEvent;
import pl.sda.partyorganising.entity.EventEntity;

import java.sql.Date;
import java.util.UUID;

public final class Event {
    private Event(UUID id, Date date, String name, String address, AccessToEvent accessToEvent) {
        this.id = id;
        this.date = date;
        this.name = name;
        this.address = address;
        this.accessToEvent = accessToEvent;
    }

    @Getter
    private final UUID id;
    private final Date date;
    private final String name;
    private final String address;
    private final AccessToEvent accessToEvent;

    public Event fromEntity(EventEntity entity) {
        return new Event(entity.getId(), entity.getDate(), entity.getName(), entity.getAddress(), entity.getAccessToEvent());
    }
}
