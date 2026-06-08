package com.project.service.budget;

import com.project.model.Budget;
import com.project.model.Transaction;

public class SharedBudget extends Budget {
    private final String partnerName;
    private final double partnerContributionRatio;

    public SharedBudget(String categoryName, double monthlyLimit, String partnerName, double partnerContributionRatio) {
        super(categoryName, monthlyLimit);
        this.partnerName = partnerName;
        this.partnerContributionRatio = partnerContributionRatio;
    }

    @Override
    public void updateBudget(Transaction transaction) {
        if(transaction.getCategory().equalsIgnoreCase(getCategoryName())){
            double userPortion = transaction.getAmount() * (1-partnerContributionRatio) ;
            this.amountSpent = this.amountSpent + userPortion;

            System.out.println("[SHARED BUDGET] Total expense was " + transaction.getAmount() + " USD. Your share added: " + userPortion + " USD.");

        if (this.amountSpent > getMonthlyLimit()){
            System.out.println("⚠️ WARNING: Shared budget for [" + getCategoryName() + "] with " + partnerName + " has been breached!");
         }
        }
    }
}
