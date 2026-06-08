package com.project.service.report;

import com.project.model.Report;
import com.project.model.User;

public class MonthlyReport extends Report {
    public MonthlyReport(String reportTitle) {
        super(reportTitle);
    }

    @Override
    public void generateReport(User user) {
        System.out.println("\n=== MONTHLY FINANCIAL REPORT ===");
        System.out.println("Title: " + getReportTitle());
        System.out.println("Generated At: " + getGeneratedAt());
        System.out.println("User: " + user.getUsername());
        System.out.println("Financial Health Score: " + String.format("%.2f", user.financialHealth()));
        System.out.println("===================================");
    }
}
