package com.project.service.account;

import com.project.model.Account;
import com.project.service.api.Accounts;

import java.time.LocalDateTime;

public class InvestmentAccount extends Account{

    private double shareValue;

    public InvestmentAccount(String institutionName) {
        super(institutionName, Accounts.InvestmentAccount.getCurrency(), Accounts.InvestmentAccount.getName());
    }

    @Override
    public double getBalance() {
        return shareValue;
    }

    @Override
    protected void syncWithProvider() {
        shareValue = Accounts.InvestmentAccount.getBalance();
    }

    @Override
    public LocalDateTime getLastSyncTime() {
        if(getBalance() == Accounts.InvestmentAccount.getBalance()) {
            return time;
        }
        return null;
    }

}
