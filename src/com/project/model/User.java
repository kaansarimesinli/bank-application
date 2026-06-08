package com.project.model;

import com.project.service.account.CheckingAccount;
import com.project.service.account.CreditCardAccount;
import com.project.service.account.InvestmentAccount;
import com.project.service.account.SavingsAccount;
import com.project.service.api.Banks;

import java.util.ArrayList;
import java.util.List;

public class User {

    private final String username;
    private final double recurringExpense;
    private final double outstandingDebt;
    private final double incomeAmount;
    private final Banks bank;
    private double totalBalance;
    List<Account> accounts = new ArrayList<>();

    public User(String username, double incomeAmount, double recurringExpense, double outstandingDebt, Banks bank) {
        this.username = username;
        this.incomeAmount = incomeAmount;
        this.recurringExpense = recurringExpense;
        this.outstandingDebt = outstandingDebt;
        this.bank = bank;
        accounts.add(new CheckingAccount(bank.getName()));
        accounts.add(new CreditCardAccount(bank.getName()));
        accounts.add(new SavingsAccount(bank.getName()));
        accounts.add(new InvestmentAccount(bank.getName()));
    }

    public String getUsername() {
        return username;
    }

    public double financialHealth() {
        double cashFlowScore = ((incomeAmount - recurringExpense - outstandingDebt) / incomeAmount * 100);
        double debtBurdenPremium = (1 - (outstandingDebt / incomeAmount)) * 50;
        return cashFlowScore + debtBurdenPremium;
    }

    public Banks getBank() {
        return bank;
    }

    public void syncAccounts() {
        for (Account account : accounts) {
            account.syncWithProvider();
        }
    }

    public void getBalances() {
        for(Account account : accounts) {
            System.out.println(account.getBalance());
            totalBalance += account.getBalance();
        }
    }

}
