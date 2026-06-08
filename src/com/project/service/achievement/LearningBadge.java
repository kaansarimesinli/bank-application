package com.project.service.achievement;

import com.project.model.Achievement;

public class LearningBadge extends Achievement {
    public LearningBadge(String badgeName, String description) {
        super(badgeName, description);
    }

    @Override
    public void displayBadge() {
        System.out.println("[LEARNING BADGE] " + getBadgeName() + ": " + getDescription() + " (Unlocked at: " + getUnlockedAt() + ")");
    }
}
