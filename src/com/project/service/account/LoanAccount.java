package com.project.service.account;

import com.project.model.Account;
import com.project.service.api.Accounts;
import java.time.LocalDateTime;

public class LoanAccount extends Account {
    private final int totalInstallments;
    private int remainingInstallments;

    public LoanAccount(String institutionName, int totalInstallments) {
        super(institutionName, Accounts.LoanAccount.getCurrency(), Accounts.LoanAccount.getName());
        this.totalInstallments = totalInstallments;
        this.remainingInstallments = totalInstallments;
        this.balance = Accounts.LoanAccount.getBalance(); // Negative liability balance
    }

    public int getTotalInstallments() {
        return totalInstallments;
    }

    public int getRemainingInstallments() {
        return remainingInstallments;
    }

    public void payInstallment(double paymentAmount) {
        this.balance += paymentAmount; // Reduces the negative loan amount
        if (this.remainingInstallments > 0) {
            this.remainingInstallments--;
        }
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    protected void syncWithProvider() {
        this.balance = Accounts.LoanAccount.getBalance();
    }

    @Override
    public LocalDateTime getLastSyncTime() {
        if (getBalance() == Accounts.LoanAccount.getBalance()) {
            return time;
        }
        return null;
    }
}