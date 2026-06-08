package com.project.model;

import java.time.LocalDateTime;

public abstract class Report {
    private final String reportTitle;
    private final LocalDateTime generatedAt;

    public Report(String reportTitle) {
        this.reportTitle = reportTitle;
        this.generatedAt = LocalDateTime.now();
    }

    public String getReportTitle() { return reportTitle; }
    public LocalDateTime getGeneratedAt() { return generatedAt; }

    public abstract void generateReport(User user);
}
