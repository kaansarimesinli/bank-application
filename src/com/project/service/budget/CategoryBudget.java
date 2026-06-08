package com.project.service.budget;

import com.project.model.Budget;
import com.project.model.Transaction;
public class CategoryBudget extends Budget {
    public CategoryBudget(String categoryName, double monthlyLimit) {
        super(categoryName, monthlyLimit);
    }
    @Override
    public void updateBudget(Transaction transaction) {
        if (transaction.getCategory().equalsIgnoreCase(getCategoryName())) {
            this.amountSpent += transaction.getAmount();
            if (this.amountSpent > getMonthlyLimit()) {
                System.out.println("⚠️ WARNING: You have exceeded your budget limit in the [" + getCategoryName() + "] category!");
            }
        }

    }


}
