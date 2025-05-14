package com.crngetafe.IFCT0062_2025_videojuegos_spring.logsystem;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class LogManager {
    @EventListener
    public void writeLog(LogEvent event) {
        System.err.println(event.getMessage());
    }
}
