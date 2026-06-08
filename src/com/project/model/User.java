package com.project.model;

import com.project.service.account.*;
import com.project.service.api.Banks;
import com.project.service.transaction.*;
import com.project.service.notification.*;

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
    private final List<Achievement> unlockedBadges = new ArrayList<>();
    private final List<Notification> notifications = new ArrayList<>();
    private final List<Report> reports = new ArrayList<>();
    private final List<Lesson> completedLessons = new ArrayList<>();

    public User(String username, double incomeAmount, double recurringExpense, double outstandingDebt, Banks bank) {
        this.username = username;
        this.incomeAmount = incomeAmount;
        this.recurringExpense = recurringExpense;
        this.outstandingDebt = outstandingDebt;
        this.bank = bank;

        // Initializing accounts
        this.accounts.add(new CheckingAccount(bank.getName()));
        this.accounts.add(new CreditCardAccount(bank.getName()));
        this.accounts.add(new SavingsAccount(bank.getName()));
        this.accounts.add(new InvestmentAccount(bank.getName()));
        this.accounts.add(new CryptoWallet("Metamask", "0x71C..."));
        this.accounts.add(new LoanAccount(bank.getName(), 12));
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
        this.totalBalance = 0; // Reset total on each calculation to prevent accumulation bug
        for (Account account : accounts) {
            System.out.println(account.getBalance());
            this.totalBalance += account.getBalance();
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

    public List<Achievement> getUnlockedBadges() {
        return unlockedBadges;
    }

    public void unlockBadge(Achievement badge) {
        this.unlockedBadges.add(badge);
        System.out.println("\n✨ [NEW ACHIEVEMENT UNLOCKED!] ✨");
        badge.displayBadge();
    }

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void addNotification(Notification notification) {
        this.notifications.add(notification);
        notification.sendNotification();
    }

    public List<Report> getReports() {
        return reports;
    }

    public void addAndGenerateReport(Report report) {
        this.reports.add(report);
        report.generateReport(this);
    }

    public List<Lesson> getCompletedLessons() {
        return completedLessons;
    }

    public void addAndStudyLesson(Lesson lesson) {
        this.completedLessons.add(lesson);
        lesson.studyLesson();
        this.evaluateActiveChallenges();
    }

    // ==========================================
    // CORE LOGIC INTEGRATION METHODS (SAFE ZONE)
    // ==========================================

    public void executeDebitTransaction(DebitTransaction transaction, Account account) {
        // 1. Deduct the amount from the selected account
        account.debit(transaction.getAmount());

        // 2. Find the matching category budget and update it
        for (Budget budget : budgets) {
            if (budget.getCategoryName().equalsIgnoreCase(transaction.getCategory())) {
                budget.updateBudget(transaction);

                // 3. Trigger notification if the budget is exceeded
                if (budget.getAmountRemaining() < 0) {
                    String alertMessage = transaction.getCategory() + " budget exceeded! Overspend amount: " + Math.abs(budget.getAmountRemaining()) + " USD";
                    this.addNotification(new BudgetAlert(alertMessage));
                }
            }
        }
    }

    public void executeCreditTransaction(CreditTransaction transaction, Account account) {
        // Add the income amount to the selected account
        account.credit(transaction.getAmount());
        System.out.println("💰 Income successfully applied: " + transaction.getAmount() + " USD");
    }

    public void executeTransferTransaction(TransferTransaction transaction, Account sourceAccount, Account destinationAccount) {
        // Deduct from the source and credit to the destination account
        sourceAccount.debit(transaction.getAmount());
        destinationAccount.credit(transaction.getAmount());
        System.out.println("🔄 Transfer Successful: " + transaction.getAmount() + " USD processed.");
    }

    public void allocateSavingsToGoal(Goal goal, Account account, double amount) {
        // 1. Deduct the amount from the selected account
        account.debit(amount);

        // 2. Add the amount to the target financial goal
        goal.addSavings(amount);
        System.out.println("🎯 Successfully allocated " + amount + " USD to your goal.");

        // 3. Check if the goal is fully achieved
        if (goal.getProgressPercentage() >= 100) {
            String milestoneMessage = "Congratulations! You have achieved 100% of a financial goal.";
            this.addNotification(new GoalMilestoneAlert(milestoneMessage));
        }
    }

    public void evaluateActiveChallenges() {
        // Iterate through all active challenges to check their status
        for (Challenge challenge : activeChallenges) {
            // If the challenge conditions are met
            if (challenge.evaluateChallenge(this)) {
                // Reward the user with the challenge's XP
                this.addXp(challenge.getXpReward());

                // Generate a system notification for the completed challenge
                String challengeMessage = "A financial challenge has been completed! Earned " + challenge.getXpReward() + " XP.";
                this.addNotification(new GoalMilestoneAlert(challengeMessage));
            }
        }
    }
}