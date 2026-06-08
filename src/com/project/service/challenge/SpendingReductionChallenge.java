package com.project.service.challenge;

import com.project.model.Budget;
import com.project.model.Challenge;
import com.project.model.User;

public class SpendingReductionChallenge extends Challenge {
    private final String category;
    private final double targetMaxSpend;

    public SpendingReductionChallenge(String challengeName, String description, int xpReward, String category, double targetMaxSpend) {
        super(challengeName, description, xpReward);
        this.category = category;
        this.targetMaxSpend = targetMaxSpend;
    }

    @Override
    public boolean evaluateChallenge(User user) {
        if (isCompleted()) return false;

        for (Budget budget : user.getBudgets()) {
            if (budget.getCategoryName().equalsIgnoreCase(category)) {

                if (budget.getAmountSpent() <= targetMaxSpend) {
                    setCompleted(true);
                    return true;
                }
            }
        }
        return false;
    }
}
