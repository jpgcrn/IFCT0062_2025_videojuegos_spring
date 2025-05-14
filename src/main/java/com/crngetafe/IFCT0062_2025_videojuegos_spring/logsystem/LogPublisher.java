package com.crngetafe.IFCT0062_2025_videojuegos_spring.logsystem;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class LogPublisher {
    private final ApplicationEventPublisher publisher;

    public LogPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public void publishLogEvent(String message) {
        LogEvent logEvent = new LogEvent(message);
        publisher.publishEvent(logEvent);
    }
}
