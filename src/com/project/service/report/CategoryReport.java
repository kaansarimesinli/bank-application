package com.project.service.report;

import com.project.model.Budget;
import com.project.model.Report;
import com.project.model.User;

public class CategoryReport extends Report {
    public CategoryReport(String reportTitle) {
        super(reportTitle);
    }

    @Override
    public void generateReport(User user) {
        System.out.println("\n=== CATEGORICAL SPENDING REPORT ===");
        System.out.println("Title: " + getReportTitle());
        System.out.println("Budget Breakdown:");
        if (user.getBudgets().isEmpty()) {
            System.out.println("No active budgets found to analyze.");
        } else {
            for (Budget budget : user.getBudgets()) {
                System.out.println("- " + budget.getCategoryName() + ": Spent "
                        + budget.getAmountSpent() + " / Limit " + budget.getMonthlyLimit() + " USD");
            }
        }
        System.out.println("=====================================");
    }
}
