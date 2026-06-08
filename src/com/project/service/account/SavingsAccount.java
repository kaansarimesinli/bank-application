package com.project.service.account;

import com.project.model.Account;
import com.project.service.api.Accounts;
import java.time.LocalDateTime;

public class SavingsAccount extends Account {

    private static final double interestRate = 0.05;

    public SavingsAccount(String institutionName) {
        super(institutionName, Accounts.SavingsAccount.getCurrency(), Accounts.SavingsAccount.getName());
        this.balance = Accounts.SavingsAccount.getBalance(); // Fixed: Now correctly initialized
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    protected void syncWithProvider() {
        this.balance = Accounts.SavingsAccount.getBalance(); // Fixed: No longer empty
    }

    @Override
    public LocalDateTime getLastSyncTime() {
        return time;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public double futureValue(int month) {
        return getBalance() + (interestRate * month * getBalance());
    }
}