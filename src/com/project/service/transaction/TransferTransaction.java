package com.project.service.transaction;

import com.project.model.Transaction;

public class TransferTransaction extends Transaction {
    private final String sourceAccount;
    private final String destinationAccount;

    public TransferTransaction(double amount, String description, String sourceAccount, String destinationAccount) {
        super(amount, description, "Transfer");
        this.sourceAccount = sourceAccount;
        this.destinationAccount = destinationAccount;
    }
    public String getSourceAccount() {
        return sourceAccount;
    }
    public String getDestinationAccount() {
        return destinationAccount;
    }

    @Override
    public void printTransactionDetails(){
        System.out.println("[TRANSFER] " + getAmount() + " USD | From: " + sourceAccount + " -> To: " + destinationAccount + " | Description: " + getDescription());
    }
}
