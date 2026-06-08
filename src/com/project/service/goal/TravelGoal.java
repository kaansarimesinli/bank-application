package com.project.service.goal;

import com.project.model.Goal;

public class TravelGoal extends Goal {
    public TravelGoal(String goalName, double targetAmount) {
        super(goalName, targetAmount);
    }

    @Override
    public void checkGoalStatus() {
        System.out.println("Goal [" + getGoalName() + "] Progress: "
                + String.format("%.2f", getProgressPercentage()) + "% ("
                + getCurrentAmount() + " / " + getTargetAmount() + " USD)");

        if (getCurrentAmount() >= getTargetAmount()) {
            System.out.println("Congratulations! You saved enough for your dream trip: " + getGoalName() + "!");
        }
    }

}