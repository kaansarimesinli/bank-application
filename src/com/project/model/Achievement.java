package com.project.model;

import java.time.LocalDateTime;

public abstract class Achievement {
    private final String badgeName;
    private final String description;
    private final LocalDateTime unlockedAt;

    public Achievement(String badgeName, String description) {
        this.badgeName = badgeName;
        this.description = description;
        this.unlockedAt = LocalDateTime.now();
    }

    public String getBadgeName() { return badgeName; }
    public String getDescription() { return description; }
    public LocalDateTime getUnlockedAt() { return unlockedAt; }

    public abstract void displayBadge();
}
