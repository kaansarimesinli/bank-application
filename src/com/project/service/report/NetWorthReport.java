package com.project.service.report;

import com.project.model.Report;
import com.project.model.User;

public class NetWorthReport extends Report {
    public NetWorthReport(String reportTitle) {
        super(reportTitle);
    }

    @Override
    public void generateReport(User user) {
        System.out.println("\n💰 === NET WORTH REPORT ===");
        System.out.println("Title: " + getReportTitle());
        System.out.println("Primary Bank: " + user.getBank().getName());
        System.out.print("Account Balances: ");
        user.getBalances(); // Orijinal kümülatif getBalances metodunu tetikler
        System.out.println("===========================");
    }
}
