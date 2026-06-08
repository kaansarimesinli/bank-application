package com.project.service.api;

import java.util.Random;

public enum Accounts {
    CheckingAccount(10000, "Checking Account", "USD"),
    SavingsAccount(0, "Savings Account", "USD"),
    CreditCardAccount(15000, "Credit Card Account", "USD"),
    InvestmentAccount(25000, "Investment Account", "USD"),
    CryptoWallet(50, "Crypto Wallet", "USD"),
    LoanAccount(-6000, "Loan Account", "USD");

    private final double balance;
    private final String name;
    private final String currency;

    Accounts (double balance, String name, String currency) {
        this.balance = balance;
        this.name = name;
        this.currency = currency;
    }

    public double getBalance() {
        return balance;
    }
    public String getName() {
        return name;
    }
    public String getCurrency() {
        return currency;
    }
}
