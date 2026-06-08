package com.project.service.account;

import com.project.model.Account;
import com.project.service.api.Accounts;

import java.time.LocalDateTime;

public class SavingsAccount extends Account{

    private static final double interestRate = 0.05;

    public SavingsAccount(String institutionName) {
        super(institutionName, Accounts.SavingsAccount.getCurrency(), Accounts.SavingsAccount.getName());
    }

    @Override
    public double getBalance() {
        return getInternalBalance();
    }

    @Override
    protected void syncWithProvider() {
    }

    @Override
    public LocalDateTime getLastSyncTime() {
            return time;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void futureValue(int month) {
        setInternalBalance(getBalance() + (interestRate * month * getBalance()));
    }
}
