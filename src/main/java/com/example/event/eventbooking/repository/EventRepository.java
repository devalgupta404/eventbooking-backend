package com.example.event.eventbooking.repository;

import com.example.event.eventbooking.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long>{

}
