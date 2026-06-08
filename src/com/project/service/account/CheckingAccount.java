package com.project.service.account;

import com.project.model.Account;
import com.project.service.api.Accounts;

import java.time.LocalDateTime;

public class CheckingAccount extends Account{

    private static final double overdraftLimit = -5000;
    private double balance;

    public CheckingAccount(String institutionName) {
        super(institutionName, Accounts.CheckingAccount.getCurrency(), Accounts.CheckingAccount.getName());
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    protected void syncWithProvider() {
        balance = Accounts.CheckingAccount.getBalance();
    }

    @Override
    public LocalDateTime getLastSyncTime() {
        if(getBalance() == Accounts.CheckingAccount.getBalance()) {
            return time;
        }
        return null;
    }

    public void checkBalance() {
        if(getBalance() < overdraftLimit) {

        }
    }
}
