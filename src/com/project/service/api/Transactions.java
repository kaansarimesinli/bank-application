package com.project.service.api;

public enum Transactions {
    RENT("Rent", 4000),
    GROCERIES("Groceries", 1000),
    FOOD("Food", 500),
    TRANSPORTATION("Transportation", 250),
    ENTERTAINMENT("Entertainment", 400),
    SUBSCRIPTIONS("Subscriptions", 300);

    private final String name;
    private final double amount;

    Transactions(String name, double amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }
    public double getAmount() {
        return amount;
    }
}
