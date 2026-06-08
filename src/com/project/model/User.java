package com.project.model;

import com.project.service.account.*;
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
        accounts.add(new CheckingAccount(bank.getName()));
        accounts.add(new CreditCardAccount(bank.getName()));
        accounts.add(new SavingsAccount(bank.getName()));
        accounts.add(new InvestmentAccount(bank.getName()));
        accounts.add(new CryptoWallet("Metamask", "0x71C..."));
        accounts.add(new LoanAccount(bank.getName(), 12));
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
        totalBalance = 0;
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
        notification.sendNotification(); // Bildirim eklendiği an polimorfik olarak konsola uyarı basar
    }

    public List<Report> getReports() {
        return reports;
    }

    public void addAndGenerateReport(Report report) {
        this.reports.add(report);
        report.generateReport(this); // Rapor listeye eklendiği an polimorfik olarak içerik analizini konsola basar
    }
    public List<Lesson> getCompletedLessons() {
        return completedLessons;
    }

    public void addAndStudyLesson(Lesson lesson) {
        this.completedLessons.add(lesson);
        lesson.studyLesson(); // Ders listeye eklendiği an polimorfik olarak içeriği konsola basar ve tamamlar
    }
}
