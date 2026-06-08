package com.project.service.goal;

import com.project.model.Goal;

public class EducationGoal extends Goal {
    private double tuitionCostEstimate;

    public EducationGoal(String goalName, double initialTuitionCost) {
        super(goalName, initialTuitionCost);
        this.tuitionCostEstimate = initialTuitionCost;
    }

    public void updateTuitionCost(double newCost) {
        this.tuitionCostEstimate = newCost;
    }

    @Override
    public double getProgressPercentage() {
        if (tuitionCostEstimate == 0) return 0;
        return (getCurrentAmount() / tuitionCostEstimate) * 100;
    }

    @Override
    public void checkGoalStatus() {
        System.out.println("Education Goal [" + getGoalName() + "] Progress: "
                + String.format("%.2f", getProgressPercentage()) + "% ("
                + getCurrentAmount() + " / " + tuitionCostEstimate + " USD)");

        if (getCurrentAmount() >= tuitionCostEstimate) {
            System.out.println("Financial Milestone! Your education expenses and tuition fees are fully covered!");
        }
    }
}
