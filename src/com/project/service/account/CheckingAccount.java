package com.project.service.account;

import com.project.model.Account;
import com.project.service.api.Accounts;
import com.project.service.exceptions.OverdraftExceededException;

import java.time.LocalDateTime;

public class CheckingAccount extends Account {

    private static final double overdraftLimit = -5000;

    public CheckingAccount(String institutionName) {
        super(institutionName, Accounts.CheckingAccount.getCurrency(), Accounts.CheckingAccount.getName());
        this.balance = Accounts.CheckingAccount.getBalance(); // Initialize from API
    }

    @Override
    public double getBalance() {
        return this.balance; // Uses inherited protected balance
    }

    @Override
    protected void syncWithProvider() {
        this.balance = Accounts.CheckingAccount.getBalance();
    }

    @Override
    public LocalDateTime getLastSyncTime() {
        if (getBalance() == Accounts.CheckingAccount.getBalance()) {
            return time;
        }
        return null;
    }

    @Override
    public void debit(double amount) {
        if ((this.balance - amount) < overdraftLimit) {
            throw new OverdraftExceededException("Overdraft limit exceeded! Maximum allowed limit is " + overdraftLimit + " USD.");
        }
        this.balance -= amount;
    }
}