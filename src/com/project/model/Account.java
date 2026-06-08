package com.project.model;

import com.project.service.exceptions.NegativeNumberException;
import com.project.service.exceptions.InsufficientFundsException;
import com.project.service.interfaces.Syncable;
import java.time.LocalDateTime;
import java.util.Scanner;

public abstract class Account implements Syncable{

    private final String institutionName;
    private final String currency;
    private final String accountType;
    protected double balance;
    protected final LocalDateTime time = LocalDateTime.now();

    public Account(String institutionName, String currency, String accountType) {
        this.institutionName = institutionName;
        this.currency = currency;
        this.accountType = accountType;
        this.balance = 0.0;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public String getCurrency() {
        return currency;
    }

    public String getAccountType() {
        return accountType;
    }

    public void credit(double amount) {
        if(amount < 0) {
            throw new NegativeNumberException("The entered value cannot be negative!");
        }
        balance += amount;
    }

    public void debit(double amount) {
        if((balance - amount) < 0) {
            throw new InsufficientFundsException("Insufficient Funds!");
        }
        balance -= amount;
    }

    public abstract double getBalance();

    protected abstract void syncWithProvider();

    @Override
    public void sync() {
        this.syncWithProvider();
    }
}
