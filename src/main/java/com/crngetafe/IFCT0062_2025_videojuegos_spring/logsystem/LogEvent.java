package com.crngetafe.IFCT0062_2025_videojuegos_spring.logsystem;

/**
 * Es un evento del sistema - POJO
 */
public class LogEvent {
    private String message;

    public LogEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}