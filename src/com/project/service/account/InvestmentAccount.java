package com.project.service.account;

import com.project.model.Account;
import com.project.service.api.Accounts;
import java.time.LocalDateTime;

public class InvestmentAccount extends Account {

    public InvestmentAccount(String institutionName) {
        super(institutionName, Accounts.InvestmentAccount.getCurrency(), Accounts.InvestmentAccount.getName());
        this.balance = Accounts.InvestmentAccount.getBalance();
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    protected void syncWithProvider() {
        this.balance = Accounts.InvestmentAccount.getBalance();
    }

    @Override
    public LocalDateTime getLastSyncTime() {
        if (getBalance() == Accounts.InvestmentAccount.getBalance()) {
            return time;
        }
        return null;
    }
}