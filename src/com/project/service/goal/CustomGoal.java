package com.project.service.goal;

import com.project.model.Goal;

public class CustomGoal extends Goal {
    private final String goalNotes;
    public CustomGoal(String goalName, double targetAmount, String goalNotes) {
        super(goalName, targetAmount);
        this.goalNotes = goalNotes;
    }
    public String getGoalNotes() {
        return goalNotes;
    }
    @Override
    public void checkGoalStatus() {
        System.out.println("🎯 Custom Goal [" + getGoalName() + "] Progress: "
                + String.format("%.2f", getProgressPercentage()) + "% ("
                + getCurrentAmount() + " / " + getTargetAmount() + " USD)");
        System.out.println("Notes: " + goalNotes);

        if (getCurrentAmount() >= getTargetAmount()) {
            System.out.println("🎉 Success! You have achieved your custom goal: " + getGoalName() + "!");
        }
    }
}
