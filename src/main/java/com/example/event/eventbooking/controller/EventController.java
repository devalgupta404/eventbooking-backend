package com.example.event.eventbooking.controller;

import com.example.event.eventbooking.model.Event;
import com.example.event.eventbooking.service.EventService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/events")
public class EventController {
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }
    @PostMapping("/create")
    public Event createEvent(@RequestBody Event event) {
        return eventService.createEvent(event);
    }

    @PostMapping("/book/{id}")
    public Event bookSeat(@PathVariable Long id) {
        return eventService.bookSeat(id);
    }
}
