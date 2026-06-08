package com.project.service.transaction;

import com.project.model.Transaction;

public class DebitTransaction extends Transaction {

    public DebitTransaction(double amount, String description, String category) {
    super(amount, description, category);
    }
    @Override
    public void printTransactionDetails() {
        System.out.println("[EXPENSE] -" + getAmount() + " USD | Category: " + getCategory() + " | Description: " + getDescription());    }
}
