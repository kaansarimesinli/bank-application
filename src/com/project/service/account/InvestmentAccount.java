package com.project.service.account;

import com.project.model.Account;
import com.project.service.api.Accounts;

import java.time.LocalDateTime;

public class InvestmentAccount extends Account{

    public InvestmentAccount(String institutionName) {
        super(institutionName, Accounts.InvestmentAccount.getCurrency(), Accounts.InvestmentAccount.getName());
    }

    @Override
    public double getBalance() {
        return getInternalBalance();
    }

    @Override
    protected void syncWithProvider() {
        setInternalBalance(Accounts.InvestmentAccount.getBalance());
    }

    @Override
    public LocalDateTime getLastSyncTime() {
        if(getBalance() == Accounts.InvestmentAccount.getBalance()) {
            return time;
        }
        return null;
    }

}
