package com.project.service.budget;

import com.project.model.Budget;
import com.project.model.Transaction;

public class RollingBudget extends Budget {
    private double rolloverBalance;
    public RollingBudget(String categoryName, double monthlyLimit, double previousUnspent) {
        super(categoryName, monthlyLimit);
        this.rolloverBalance = previousUnspent;
    }
    @Override
    public double getAmountRemaining() {
        return (getMonthlyLimit() + rolloverBalance) - amountSpent;
    }
    @Override
    public void updateBudget(Transaction transaction) {
        if (transaction.getCategory().equalsIgnoreCase(getCategoryName())) {
            this.amountSpent += transaction.getAmount();

            double totalAvailableLimit = getMonthlyLimit() + rolloverBalance;
            if (this.amountSpent > totalAvailableLimit) {
                System.out.println("⚠️ WARNING: Rolling budget exceeded for [" + getCategoryName() + "]! (Including Rollover: " + rolloverBalance + " USD)");
            }
        }
    }
}
