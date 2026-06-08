package com.project.model;


import java.time.LocalDateTime;

public abstract class Transaction {
    private final double amount;
    private final String description;
    private final LocalDateTime timestamp;
    private final String category;

    public Transaction(double amount, String description, String category) {
        this.amount = amount;
        this.description = description;
        this.category = category;
        this.timestamp = LocalDateTime.now();
    }
    public double getAmount() { return amount; }
    public String getDescription() { return description; }
    public String getCategory() { return category; }
    public LocalDateTime getTimestamp() { return timestamp; }

    public abstract void printTransactionDetails();

}
