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
    private final List<Account> accounts = new ArrayList<>();

    private final List<Budget> budgets = new ArrayList<>();
    private final List<Goal> goals = new ArrayList<>();
    private final List<Challenge> activeChallenges = new ArrayList<>();
    private int xp = 0;
    private String currentTier = "Rookie";

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

    public List<Account> getAccounts() {
        return accounts;
    }

    public List<Budget> getBudgets() {
        return budgets;
    }
   public List<Goal> getGoals() {
        return goals;
   }
    public List<Challenge> getActiveChallenges() {
        return activeChallenges;
 }
 public int getXp() {
        return xp;
 }
    public String getCurrentTier() {
        return currentTier;
    }
    public void addBudget(Budget budget) {
        this.budgets.add(budget);
    }
    public void addGoal(Goal goal) {
        this.goals.add(goal);
    }
    public void addChallenge(Challenge challenge) {
        this.activeChallenges.add(challenge);
    }
    public void addXp(int amount) {
        this.xp += amount;
        System.out.println("✨ You earned " + amount + " XP! Total XP: " + this.xp);

        // Tier progression based on milestone points
        if (this.xp >= 400) {
            currentTier = "Financial Guru";
        } else if (this.xp >= 300) {
            currentTier = "Wealth Builder";
        } else if (this.xp >= 200) {
            currentTier = "Investor";
        } else if (this.xp >= 100) {
            currentTier = "Saver";
        }
    }

}
