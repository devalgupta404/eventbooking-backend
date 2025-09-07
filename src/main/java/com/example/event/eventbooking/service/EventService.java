package com.example.event.eventbooking.service;

import com.example.event.eventbooking.model.Event;
import com.example.event.eventbooking.repository.EventRepository;
import org.springframework.stereotype.Service;

@Service
public class EventService {
    private final EventRepository eventRepository;
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }
    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }
    public Event bookSeat(Long eventId) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        if (event.getAvailableSeats() > 0) {
            event.setAvailableSeats(event.getAvailableSeats() - 1);
            return eventRepository.save(event);
        } else {
            throw new RuntimeException("No seats available");
        }
    }
}