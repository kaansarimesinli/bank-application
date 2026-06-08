package com.project.service.goal;

import com.project.model.Goal;

public class EmergencyFundGoal extends Goal {
    private final int monthsOfCover;

    public EmergencyFundGoal(String goalName, double targetAmount, int monthsOfCover) {
        super(goalName, targetAmount);
        this.monthsOfCover = monthsOfCover;
    }

    @Override
    public void checkGoalStatus() {
        System.out.println("🛡️ Emergency Fund [" + getGoalName() + "] Progress: "
                + String.format("%.2f", getProgressPercentage()) + "% ("
                + getCurrentAmount() + " / " + getTargetAmount() + " USD)");
        System.out.println("Target covers roughly " + monthsOfCover + " months of basic living expenses.");

        if (getCurrentAmount() >= getTargetAmount()) {
            System.out.println("🎉 Amazing! You have built a secure financial safety net!");
        }
    }
}
