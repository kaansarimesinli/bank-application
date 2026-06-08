package com.project.service.transaction;

import com.project.model.Transaction;

public class CreditTransaction extends Transaction {
    public CreditTransaction(double amount, String description, String category) {
        super(amount, description, category);
    }
    @Override
    public void printTransactionDetails() {
        System.out.println("[INCOME] +" + getAmount() + " USD | Category: " + getCategory() + " | Description: " + getDescription());
    }
}
