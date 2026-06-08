package com.project.model;

import java.time.LocalDateTime;

public abstract class Notification {
    private final String message;
    private final LocalDateTime timestamp;
    private boolean isRead;

    public Notification(String message) {
        this.message = message;
        this.timestamp = LocalDateTime.now();
        this.isRead = false;
    }

    public String getMessage() { return message; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public boolean isRead() { return isRead; }

    public void markAsRead() { this.isRead = true; }

    public abstract void sendNotification();
}
