package com.project.main;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import com.project.model.*;
import com.project.service.account.*;
import com.project.service.achievement.*;
import com.project.service.api.*;
import com.project.service.budget.*;
import com.project.service.challenge.*;
import com.project.service.exceptions.*;
import com.project.service.goal.*;
import com.project.service.lesson.*;
import com.project.service.notification.*;
import com.project.service.report.*;
import com.project.service.transaction.*;

public class Main {

    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        // ==========================================
        // STEP 1: USER REGISTRATION & INITIALIZATION
        // ==========================================
        System.out.println("           FINANCIAL MANAGEMENT APPLICATION");
        System.out.println("=======================================================");
        System.out.print("Please enter your username: ");
        String username = input.nextLine();

        double incomeAmount = secureBalance("Please enter your income amount: ");
        double recurringExpense = secureBalance("Please enter your recurring expense amount: ");
        double outstandingDebt = secureBalance("Please enter your outstanding debt amount: ");

        System.out.println("\nWelcome to the Financial Management Application!\n");

        // ==========================================
        // STEP 2: BANK SELECTION SCREEN
        // ==========================================
        System.out.println("        BANK SELECTION SCREEN");
        System.out.println("======================================");
        Banks[] banks = Banks.values();
        for(int i = 0; i < banks.length; i++) {
            System.out.printf("%d. %s%n", i + 1, banks[i].getName());
        }
        System.out.println();
        int bankSelection = secureSelection("Please select a bank: ", 1, banks.length);
        Banks selectedBank = banks[bankSelection - 1];

        // Instantiating Core User Controller Entity
        User newUser = new User(username, incomeAmount, recurringExpense, outstandingDebt, selectedBank);

        // Simulated API Account Stream Synchronization Animation
        System.out.print("Your accounts are being imported");
        try {
            for(int i = 1; i <= 3; i++) {
                TimeUnit.MILLISECONDS.sleep(500);
                System.out.print(".");
            }
            TimeUnit.MILLISECONDS.sleep(20);
            System.out.println("\n\nBank synchronization completed successfully!");
            newUser.syncAccounts();
        } catch (InterruptedException e) {
            System.out.println("\n\nThe process was interrupted!");
        }

        // ==========================================
        // STEP 3: DATA SYSTEM BOOTSTRAPPING
        // ==========================================
        // Initializing system budgets
        newUser.addBudget(new CategoryBudget("Food", 400.0));
        newUser.addBudget(new RollingBudget("Groceries", 300.0, 50.0));
        newUser.addBudget(new SharedBudget("Rent", 1200.0, "Yusuf", 0.5));

        // Instantiating all polymorphic goal subtypes
        newUser.addGoal(new TravelGoal("Summer Trip", 1000.0));
        newUser.addGoal(new EducationGoal("Software Engineering Degree", 2500.0));
        newUser.addGoal(new CustomGoal("Buy Gaming Laptop", 1500.0, "For Unity/Unreal game development"));
        newUser.addGoal(new EmergencyFundGoal("Safety Net Fund", 5000.0, 6));
        newUser.addGoal(new InvestmentSeedGoal("Crypto Seed Capital", 3000.0));

        // Instantiating all engagement game loop challenges
        newUser.addChallenge(new WeeklyBudgetChallenge("Food Discipline", "Keep Food budget intact", 60, "Food"));
        newUser.addChallenge(new LearningChallenge("Scholar Path", "Complete budgeting lesson", 50, "Budgeting"));
        newUser.addChallenge(new SavingsStreakChallenge("Health Booster", "Maintain financial health above 60", 80, 7));
        newUser.addChallenge(new SpendingReductionChallenge("Groceries Cut", "Keep groceries spent under 200 USD", 70, "Groceries", 200.0));

        // ==========================================
        // STEP 4: MASTER SWITCHBOARD LOOP
        // ==========================================
        while (true) {
            System.out.println("\n=======================================");
            System.out.println("             ACCOUNT PANEL");
            System.out.println("=======================================");
            System.out.println("1. Central Financial Management & Banking");
            System.out.println("2. Financial Academy & Gamification Hub");
            System.out.println("3. Exit System\n");
            int panelSelection = secureSelection("Please select: ", 1, 3);

            if (panelSelection == 3) {
                System.out.println("The application has been closed!");
                System.exit(0);
            }

            try {
                // ------------------------------------------
                // SUB PANEL 1: CORE BANKING & LEDGER
                // ------------------------------------------
                if (panelSelection == 1) {
                    boolean inFinPanel = true;
                    while (inFinPanel) {
                        System.out.println("\n============================================");
                        System.out.println("         FINANCIAL MANAGEMENT PANEL");
                        System.out.println("============================================");
                        System.out.println("1. Process Income Transaction");
                        System.out.println("2. Process Expense Transaction");
                        System.out.println("3. Run Internal Account Transfer");
                        System.out.println("4. Savings Goal Contribution");
                        System.out.println("5. Pay Loan Installment");
                        System.out.println("6. Simulate Savings Future Value");
                        System.out.println("7. Scan System Invoices & Bills");
                        System.out.println("8. Run Financial Analysis & Reports");
                        System.out.println("9. Check Dashboard Asset Net Worth");
                        System.out.println("10. Return to Master Switchboard");
                        int op = secureSelection("Operation Choice: ", 1, 10);

                        switch (op) {
                            case 1: // INCOME PROCESSING
                                System.out.println("\n--- PROCESS INCOME ---");
                                for (int i = 0; i < newUser.getAccounts().size(); i++) {
                                    System.out.printf("%d. %s%n", i + 1, newUser.getAccounts().get(i).getAccountType());
                                }
                                int incAccIdx = secureSelection("Select target account: ", 1, newUser.getAccounts().size()) - 1;
                                double incAmount = secureBalance("Enter income amount (USD): ");
                                System.out.print("Enter description: ");
                                String incDesc = input.nextLine();

                                CreditTransaction creditTx = new CreditTransaction(incAmount, incDesc, "Income");
                                newUser.executeCreditTransaction(creditTx, newUser.getAccounts().get(incAccIdx));
                                creditTx.printTransactionDetails();
                                break;

                            case 2: // EXPENSE WITH PROTECTION HOOKS
                                System.out.println("\n--- PROCESS EXPENSE ---");
                                for (int i = 0; i < newUser.getAccounts().size(); i++) {
                                    System.out.printf("%d. %s%n", i + 1, newUser.getAccounts().get(i).getAccountType());
                                }
                                int expAccIdx = secureSelection("Select funding source account: ", 1, newUser.getAccounts().size()) - 1;
                                double expAmount = secureBalance("Enter expense amount (USD): ");
                                System.out.print("Enter category (Food/Groceries/Rent): ");
                                String expCategory = input.nextLine();
                                System.out.print("Enter description: ");
                                String expDesc = input.nextLine();

                                // Security Flag Trigger
                                if (expAmount >= 5000.0) {
                                    newUser.addNotification(new UnusualTransactionAlert("High risk transaction detected! Attempted to spend " + expAmount + " USD in category: " + expCategory));
                                }

                                DebitTransaction debitTx = new DebitTransaction(expAmount, expDesc, expCategory);
                                newUser.executeDebitTransaction(debitTx, newUser.getAccounts().get(expAccIdx));
                                debitTx.printTransactionDetails();

                                // Challenge Trigger State Trackers
                                boolean oldReductionStatus = newUser.getActiveChallenges().get(3).isCompleted();
                                boolean oldStreakStatus = newUser.getActiveChallenges().get(2).isCompleted();

                                newUser.evaluateActiveChallenges();

                                // Conditional Achievement Unlocks
                                if (!oldReductionStatus && newUser.getActiveChallenges().get(3).isCompleted()) {
                                    newUser.unlockBadge(new BudgetBadge("Expense Reducer", "Successfully limited spending pattern under challenge target limits."));
                                }
                                if (!oldStreakStatus && newUser.getActiveChallenges().get(2).isCompleted()) {
                                    newUser.unlockBadge(new StreakBadge("Health Sentinel", "Maintained exceptional financial health above safety benchmarks."));
                                }
                                break;

                            case 3: // ACCOUNT TO ACCOUNT TRANSFER
                                System.out.println("\n--- RUN INTERNAL TRANSFER ---");
                                for (int i = 0; i < newUser.getAccounts().size(); i++) {
                                    System.out.printf("%d. %s%n", i + 1, newUser.getAccounts().get(i).getAccountType());
                                }
                                int srcIdx = secureSelection("Select source account: ", 1, newUser.getAccounts().size()) - 1;
                                int destIdx = secureSelection("Select destination account: ", 1, newUser.getAccounts().size()) - 1;
                                double xferAmount = secureBalance("Enter transfer amount (USD): ");

                                Account srcAcc = newUser.getAccounts().get(srcIdx);
                                Account destAcc = newUser.getAccounts().get(destIdx);

                                TransferTransaction xferTx = new TransferTransaction(xferAmount, "Internal Transfer", srcAcc.getAccountType(), destAcc.getAccountType());
                                newUser.executeTransferTransaction(xferTx, srcAcc, destAcc);
                                xferTx.printTransactionDetails();
                                break;

                            case 4: // STRATEGIC GOAL FUNDING
                                System.out.println("\n--- SAVINGS GOAL CONTRIBUTION ---");
                                if (newUser.getGoals().isEmpty()) {
                                    System.out.println("No active goals found.");
                                    break;
                                }
                                for (int i = 0; i < newUser.getGoals().size(); i++) {
                                    System.out.printf("%d. %s%n", i + 1, newUser.getGoals().get(i).getGoalName());
                                }
                                int goalIdx = secureSelection("Select target financial goal: ", 1, newUser.getGoals().size()) - 1;

                                for (int i = 0; i < newUser.getAccounts().size(); i++) {
                                    System.out.printf("%d. %s%n", i + 1, newUser.getAccounts().get(i).getAccountType());
                                }
                                int fundAccIdx = secureSelection("Select source funding account: ", 1, newUser.getAccounts().size()) - 1;
                                double allocAmount = secureBalance("Enter allocation amount (USD): ");

                                Goal selectedGoal = newUser.getGoals().get(goalIdx);
                                Account fundingAccount = newUser.getAccounts().get(fundAccIdx);

                                double oldProgress = selectedGoal.getProgressPercentage();
                                newUser.allocateSavingsToGoal(selectedGoal, fundingAccount, allocAmount);
                                selectedGoal.checkGoalStatus();

                                if (oldProgress < 100 && selectedGoal.getProgressPercentage() >= 100) {
                                    newUser.unlockBadge(new SavingsBadge("Target Master", "Fully funded the investment goal: " + selectedGoal.getGoalName()));
                                }
                                break;

                            case 5: // LOAN BALANCING INTERFACE
                                System.out.println("\n--- PAY LOAN INSTALLMENT ---");
                                LoanAccount targetLoan = null;
                                for (Account acc : newUser.getAccounts()) {
                                    if (acc instanceof LoanAccount) {
                                        targetLoan = (LoanAccount) acc;
                                    }
                                }
                                if (targetLoan != null) {
                                    System.out.println("Current Loan Liability Balance: " + targetLoan.getBalance() + " USD");
                                    System.out.println("Remaining Installments: " + targetLoan.getRemainingInstallments() + " months");
                                    double payAmount = secureBalance("Enter payment amount to reduce loan: ");

                                    targetLoan.payInstallment(payAmount);
                                    System.out.println("Installment processed! New Loan Debt: " + targetLoan.getBalance() + " USD");
                                }
                                break;

                            case 6: // INTEREST PREDICTION COMPONENT
                                System.out.println("\n--- SIMULATE SAVINGS FUTURE VALUE ---");
                                SavingsAccount savingsAcc = null;
                                for (Account acc : newUser.getAccounts()) {
                                    if (acc instanceof SavingsAccount) {
                                        savingsAcc = (SavingsAccount) acc;
                                    }
                                }
                                if (savingsAcc != null) {
                                    System.out.println("Your Current Savings Balance: " + savingsAcc.getBalance() + " USD");
                                    System.out.println("Annual Interest Rate: " + (savingsAcc.getInterestRate() * 100) + "%");
                                    int months = secureSelection("Enter timeline (Months): ", 1, 120);

                                    double projectedValue = savingsAcc.futureValue(months);
                                    System.out.printf("Future compound simulation result: %.2f USD%n", projectedValue);
                                }
                                break;

                            case 7: // AUTOMATED INVOICE ENGINE
                                System.out.println("\n--- SCAN SYSTEM INVOICES & BILLS ---");
                                System.out.println("Scanning pending system infrastructure invoices...");
                                newUser.addNotification(new BillReminder("Upcoming Rent Invoice: 600.00 USD due in 5 days."));
                                newUser.addNotification(new BillReminder("Streaming Subscription Bill: 14.99 USD due tomorrow."));
                                System.out.println("Scanner active. Invoices added to notifications log framework.");
                                break;

                            case 8: // ANALYTICS & STATEMENTS
                                System.out.println("\n--- RUN REPORTS AND ANALYSIS ---");
                                System.out.println("1. Categorical Spending Breakdown");
                                System.out.println("2. Monthly Financial Snapshot");
                                System.out.println("3. Comprehensive Net Worth Statement");
                                System.out.println("4. Annual Performance Summary");
                                int rptType = secureSelection("Select report layout: ", 1, 4);

                                Report generatedReport;
                                if (rptType == 1) generatedReport = new CategoryReport("Live Spending Breakdown");
                                else if (rptType == 2) generatedReport = new MonthlyReport("Monthly Financial Analysis");
                                else if (rptType == 3) generatedReport = new NetWorthReport("Asset Statement Ledger");
                                else generatedReport = new AnnualReport("Consolidated Annual Performance");

                                newUser.addAndGenerateReport(generatedReport);
                                break;

                            case 9: // ACCOUNT TRACE METRICS INTERFACE
                                System.out.println("\n--- DASHBOARD ASSET NET WORTH ---");
                                System.out.println("User Account Name: " + newUser.getUsername());
                                System.out.println("Current Status Tier: [" + newUser.getCurrentTier() + "]");
                                System.out.printf("Financial Health Score: %.2f/150.00%n", newUser.financialHealth());
                                System.out.println("\nIndividual Balances Breakdown (Asset Sources):");
                                for (Account acc : newUser.getAccounts()) {
                                    if (acc instanceof CryptoWallet) {
                                        System.out.printf("- Account Type: %-20s | Provider Bank: %-10s | Balance: %,12.2f %s%n",
                                                acc.getAccountType(), acc.getInstitutionName(), acc.getBalance(), acc.getCurrency());
                                    } else {
                                        System.out.printf("- Account Type: %-20s | Provider Bank: %-10s | Balance: %,12.2f %s%n",
                                                acc.getAccountType(), acc.getInstitutionName(), acc.getBalance(), acc.getCurrency());
                                    }
                                }
                                break;

                            case 10: // BREAK CONTEXT PANEL
                                inFinPanel = false;
                                break;
                        }
                    }
                }

                // ------------------------------------------
                // SUB PANEL 2: ACADEMY & GAMIFICATION HUB
                // ------------------------------------------
                if (panelSelection == 2) {
                    boolean inAcadPanel = true;
                    while (inAcadPanel) {
                        System.out.println("\n============================================");
                        System.out.println("         FINANCIAL ACADEMY PANEL");
                        System.out.println("============================================");
                        System.out.println("1. Study Financial Literacy Course");
                        System.out.println("2. Attend National Technical Summit");
                        System.out.println("3. Review Active Engagement Challenges");
                        System.out.println("4. View Alerts & Achievement Badges");
                        System.out.println("5. Return to Master Switchboard");
                        int academyOp = secureSelection("Operation Choice: ", 1, 5);

                        switch (academyOp) {
                            case 1: // COURSE SELECTION LOOP
                                System.out.println("\n--- CHOOSE COURSE MODULE ---");
                                System.out.println("1. Budgeting Management Lesson");
                                System.out.println("2. Credit and Debt Optimization");
                                System.out.println("3. Investing Fundamentals");
                                System.out.println("4. Tax Awareness Framework");
                                int courseChoice = secureSelection("Select course: ", 1, 4);

                                Lesson academicLesson;
                                if (courseChoice == 1) academicLesson = new BudgetingLesson("Mastering the 50/30/20 Rule");
                                else if (courseChoice == 2) academicLesson = new CreditLesson("Optimizing Debt Structures");
                                else if (courseChoice == 3) academicLesson = new InvestingLesson("Capital Allocation Metrics");
                                else academicLesson = new TaxLesson("Corporate Write-offs & Net Worth");

                                for (Challenge ch : newUser.getActiveChallenges()) {
                                    if (ch instanceof LearningChallenge) {
                                        ((LearningChallenge) ch).completeQuiz();
                                    }
                                }

                                newUser.addAndStudyLesson(academicLesson);
                                newUser.unlockBadge(new LearningBadge("Scholar Achievement", "Finished study module on: " + academicLesson.getLessonTitle()));
                                break;

                            case 2: // EXTERNAL SYSTEM PROFESSIONAL SEMINAR INTEGRATION
                                System.out.println("\n--- ATTEND NATIONAL TECHNICAL SUMMIT ---");
                                System.out.println("Registering user for the official engineering summit...");
                                try {
                                    TimeUnit.MILLISECONDS.sleep(600);
                                    System.out.println("Ticket generated! Attending presentations and seminars...");
                                    TimeUnit.MILLISECONDS.sleep(40);
                                } catch (InterruptedException e) {
                                    System.out.println("Interrupted registration!");
                                }
                                newUser.unlockBadge(new EventBadge("Zirve IEEE Certificate", "Successfully attended engineering keynotes and fintech development panels."));
                                break;

                            case 3: // CHALLENGE STATUS RUN LOGS
                                System.out.println("\n--- ACTIVE ENGAGEMENT CHALLENGES ---");
                                if (newUser.getActiveChallenges().isEmpty()) {
                                    System.out.println("No challenges running currently.");
                                } else {
                                    for (Challenge ch : newUser.getActiveChallenges()) {
                                        System.out.println("- [" + ch.getChallengeName() + "]: " + ch.getDescription() + " | Reward: " + ch.getXpReward() + " XP | Completed: " + ch.isCompleted());
                                    }
                                }
                                break;

                            case 4: // SYSTEM PROGRESS METRICS LOGS
                                System.out.println("\n--- SYSTEM NOTIFICATIONS LOG ---");
                                if (newUser.getNotifications().isEmpty()) {
                                    System.out.println("No alerts found.");
                                } else {
                                    for (Notification note : newUser.getNotifications()) {
                                        note.markAsRead();
                                    }
                                }

                                System.out.println("\n--- UNLOCKED ACHIEVEMENT BADGES ---");
                                if (newUser.getUnlockedBadges().isEmpty()) {
                                    System.out.println("Keep working to unlock your first milestone badge!");
                                } else {
                                    for (Achievement badge : newUser.getUnlockedBadges()) {
                                        badge.displayBadge();
                                    }
                                }
                                break;

                            case 5: // BREAK CONTEXT PANEL
                                inAcadPanel = false;
                                break;
                        }
                    }
                }
            } catch (InsufficientFundsException | OverdraftExceededException | NegativeNumberException e) {
                System.out.println("\n[TRANSACTION BLOCKED]: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("\n[SYSTEM ERROR]: An unexpected error occurred: " + e.getMessage());
            }
        }
    }

    public static int secureSelection(String message, int min, int max) {
        while(true) {
            System.out.print(message);
            try {
                int temporarySelection = Integer.parseInt(input.nextLine());

                if(temporarySelection < min || temporarySelection > max) {
                    throw new IllegalArgumentException();
                }
                return temporarySelection;

            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input!");
            }
        }
    }

    public static double secureBalance(String message) {
        while(true) {
            System.out.print(message);
            try {
                return Double.parseDouble(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input!");
            }
        }
    }
}