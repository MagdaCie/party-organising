package pl.sda.partyorganising.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sda.partyorganising.entity.EventEntity;
import pl.sda.partyorganising.entity.UserEntity;
import pl.sda.partyorganising.repository.EventRepository;
import pl.sda.partyorganising.repository.UserRepository;
import pl.sda.partyorganising.web.controller.CreateEventRequest;

import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;
    private final UserRepository userRepository;

    public UUID createNewEvent(CreateEventRequest request, UUID organizerId) {
        UserEntity userEntity = userRepository.getById(organizerId);
        EventEntity eventEntity = new EventEntity(request.date, request.name, request.address, request.accessToEvent, userEntity, Set.of());
        eventRepository.saveAndFlush(eventEntity);
        return eventEntity.getId();
    }
}
