package pl.sda.partyorganising.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import pl.sda.partyorganising.entity.EventEntity;
import pl.sda.partyorganising.service.EventService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "events")
@RequiredArgsConstructor
public class EventsController {

    private final EventService eventService;

    @GetMapping
    public ResponseEntity<List<EventEntity>> getEvents(){
        return ResponseEntity.ok(eventService.getEvents());
    }
    @GetMapping("/events/{id}")
    public ResponseEntity<EventEntity> getEvent(@PathVariable("id") UUID uuid) {
        return ResponseEntity.ok(eventService.getEvent(uuid));
    }

    @PostMapping()
    public ResponseEntity<Void> createNewEvent(@RequestBody CreateEventRequest request, UriComponentsBuilder uriComponentsBuilder) {
        //TODO: retrieve organizerId from session
        UUID organizerId = UUID.fromString("8839d2a0-7e7e-448d-bb44-a454276fc58a");
        UUID newEventId = eventService.createNewEvent(request, organizerId);
        UriComponents uriComponents = uriComponentsBuilder.path("/events/{id}").buildAndExpand(newEventId);
        return ResponseEntity.created(uriComponents.toUri()).build();
    }
}
