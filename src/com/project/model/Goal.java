package com.project.model;

public abstract class Goal {
    private final String goalName;
    private final double targetAmount;
    protected double currentAmount;

    public Goal(String goalName, double targetAmount) {

        this.goalName = goalName;
        this.targetAmount = targetAmount;
        this.currentAmount = 0.0;
    }
    public String getGoalName() {
        return goalName;
    }
    public double getTargetAmount() {
        return targetAmount;
    }
    public double getCurrentAmount() {
        return currentAmount;
    }

    public double getProgressPercentage() {
        if (targetAmount == 0) return 0;
        return (currentAmount / targetAmount) * 100;
    }
    public void addSavings(double amount) {
        if (amount > 0) {
            this.currentAmount += amount;
        }
    }
    public abstract void checkGoalStatus();

}
