package com.project.service.achievement;

import com.project.model.Achievement;

public class SavingsBadge extends Achievement {
    public SavingsBadge(String badgeName, String description) {
        super(badgeName, description);
    }

    @Override
    public void displayBadge() {
        System.out.println("💰 [SAVINGS BADGE] " + getBadgeName() + ": " + getDescription() + " (Unlocked at: " + getUnlockedAt() + ")");
    }
}
