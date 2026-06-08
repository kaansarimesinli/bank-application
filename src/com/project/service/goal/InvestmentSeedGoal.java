package com.project.service.goal;

import com.project.model.Goal;

public class InvestmentSeedGoal extends Goal {
    public InvestmentSeedGoal(String goalName, double targetAmount) {
        super(goalName, targetAmount);
    }
    @Override
    public void checkGoalStatus() {
        System.out.println("Investment Seed [" + getGoalName() + "] Progress: "
                + String.format("%.2f", getProgressPercentage()) + "% ("
                + getCurrentAmount() + " / " + getTargetAmount() + " USD)");

        if (getCurrentAmount() >= getTargetAmount()) {
            System.out.println("Seed capital secured! You are ready to move this money into your Investment Account!");
        }
    }
}
