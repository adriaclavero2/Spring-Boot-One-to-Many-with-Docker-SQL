package services;

import models.Event;

import java.util.List;

public interface EventService {
    Event saveEvent(Event event);

    List<Event> getAllEvents();

    Event getEventById(Long id);
}
