package com.project.service.account;

import com.project.model.Account;
import com.project.service.api.Accounts;
import java.time.LocalDateTime;

public class CreditCardAccount extends Account {

    public CreditCardAccount(String institutionName) {
        super(institutionName, Accounts.CreditCardAccount.getCurrency(), Accounts.CreditCardAccount.getName());
        this.balance = Accounts.CreditCardAccount.getBalance(); // Limit or balance mapped to protected balance
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    protected void syncWithProvider() {
        this.balance = Accounts.CreditCardAccount.getBalance();
    }

    @Override
    public LocalDateTime getLastSyncTime() {
        if (getBalance() == Accounts.CreditCardAccount.getBalance()) {
            return time;
        }
        return null;
    }
}