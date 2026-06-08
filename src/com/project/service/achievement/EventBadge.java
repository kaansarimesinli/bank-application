package com.project.service.achievement;

import com.project.model.Achievement;

public class EventBadge extends Achievement {
    public EventBadge(String badgeName, String description) {
        super(badgeName, description);
    }

    @Override
    public void displayBadge() {
        System.out.println("[EVENT BADGE] " + getBadgeName() + ": " + getDescription() + " (Unlocked at: " + getUnlockedAt() + ")");
    }
}
