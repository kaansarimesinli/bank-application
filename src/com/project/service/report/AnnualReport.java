package com.project.service.report;

import com.project.model.Report;
import com.project.model.User;

public class AnnualReport extends Report {
    public AnnualReport(String reportTitle) {
        super(reportTitle);
    }

    @Override
    public void generateReport(User user) {
        System.out.println("\n📈 === ANNUAL PERFORMANCE REPORT ===");
        System.out.println("Title: " + getReportTitle());
        System.out.println("Generated At: " + getGeneratedAt());
        System.out.println("Current Tier: " + user.getCurrentTier());
        System.out.println("Total Accumulated XP: " + user.getXp());
        System.out.println("===================================");
    }
}
