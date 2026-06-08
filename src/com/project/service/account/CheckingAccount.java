package com.project.service.account;

import com.project.model.Account;
import com.project.service.api.Accounts;

import java.time.LocalDateTime;

public class CheckingAccount extends Account{

    private static final double overdraftLimit = -5000;

    public CheckingAccount(String institutionName) {
        super(institutionName, Accounts.CheckingAccount.getCurrency(), Accounts.CheckingAccount.getName());
    }

    @Override
    public double getBalance() {
        return getInternalBalance();
    }

    @Override
    protected void syncWithProvider() {
        setInternalBalance(Accounts.CheckingAccount.getBalance());
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
