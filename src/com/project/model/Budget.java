package com.project.model;

public abstract class Budget {
    private final String categoryName;
    private final double monthlyLimit;
    protected double amountSpent;
    public Budget(String categoryName, double monthlyLimit) {
        this.categoryName = categoryName;
        this.monthlyLimit = monthlyLimit;
        this.amountSpent = 0.0;
    }

    public String getCategoryName() { return categoryName; }
    public double getMonthlyLimit() { return monthlyLimit; }
    public double getAmountSpent() { return amountSpent; }

    public double getAmountRemaining() {
        return monthlyLimit - amountSpent;
    }

    public abstract void updateBudget(Transaction transaction);
}
