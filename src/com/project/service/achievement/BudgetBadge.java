package com.project.service.achievement;

import com.project.model.Achievement;

public class BudgetBadge extends Achievement {
    public BudgetBadge(String badgeName, String description) {
        super(badgeName, description);
    }

    @Override
    public void displayBadge() {
        System.out.println("🛡️ [BUDGET BADGE] " + getBadgeName() + ": " + getDescription() + " (Unlocked at: " + getUnlockedAt() + ")");
    }
}
