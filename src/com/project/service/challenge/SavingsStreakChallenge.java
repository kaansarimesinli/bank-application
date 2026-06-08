package com.project.service.challenge;

import com.project.model.Challenge;
import com.project.model.User;

public class SavingsStreakChallenge extends Challenge {
    private final int requiredStreakDays;
    public SavingsStreakChallenge(String challengeName, String description, int xpReward, int requiredStreakDays) {
        super(challengeName, description, xpReward);
        this.requiredStreakDays = requiredStreakDays;
    }

    @Override
    public boolean evaluateChallenge(User user) {
        if (isCompleted()) return false;

        if (user.financialHealth() > 60) {
            setCompleted(true);
            return true;
        }
        return false;
    }
}
