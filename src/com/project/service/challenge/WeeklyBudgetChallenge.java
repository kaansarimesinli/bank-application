package com.project.service.challenge;

import com.project.model.Budget;
import com.project.model.Challenge;
import com.project.model.User;

public class WeeklyBudgetChallenge extends Challenge {
    private final String targetCategory;

    public WeeklyBudgetChallenge(String challengeName, String description, int xpReward, String targetCategory) {
        super(challengeName, description, xpReward);
        this.targetCategory = targetCategory;
    }

   @Override
    public boolean evaluateChallenge(User user) {
        if (isCompleted()) return false;

        for (Budget budget : user.getBudgets()){
            if (budget.getCategoryName().equalsIgnoreCase(targetCategory)){
                if(budget.getAmountSpent() <= budget.getMonthlyLimit()){
                    return true;
                }
            }
        }
        return  false;
   }
}
