package com.project.main;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import com.project.model.User;
import com.project.service.api.Banks;

public class Main {

    private static final Scanner input = new Scanner(System.in);

    public static void main() {

        System.out.println("           FINANCIAL MANAGEMENT APPLICATION");
        System.out.println("=======================================================");
        System.out.print("Please enter your username: ");
        String username = input.nextLine();
        double incomeAmount = secureBalance("Please enter your income amount: ");;
        double recurringExpense = secureBalance("Please enter your recurring expense amount: ");
        double outstandingDebt = secureBalance("Please enter your outstanding debt amount: ");

        System.out.println("\nWelcome to the Financial Management Application!\n");

        System.out.println("        BANK SELECTION SCREEN");
        System.out.println("======================================");
        Banks[] banks = Banks.values();
        for(int i = 0; i < banks.length; i++) {
            System.out.printf("%d. %s%n", i + 1, banks[i].getName());
        }
        System.out.println();
        int bankSelection = secureSelection("Please select a bank: ", 1, 4);
        Banks selectedBank = banks[bankSelection - 1];

        User newUser = new User(username, incomeAmount, recurringExpense, outstandingDebt, selectedBank);
        System.out.print("Your accounts are being imported");
        try {
            for(int i = 1; i <= 3; i++) {
                TimeUnit.MILLISECONDS.sleep(500);
                System.out.print(".");
            }
            TimeUnit.MILLISECONDS.sleep(20);
            System.out.println("\n\nBank synchronization completed successfully!");
            newUser.syncAccounts();
        }catch (InterruptedException e) {
            System.out.println("\n\nThe process was interrupted!");
        }

        System.out.println("=======================================");
        System.out.println("             ACCOUNT PANEL");
        System.out.println("=======================================");
        System.out.println("1. Central Financial Management & Banking");
        System.out.println("2. Financial Academy & Gamification Hub");
        System.out.println("3. Exit System\n");
        int panelSelection = secureSelection("Please select: ", 1, 3);

        if (panelSelection == 1) {
            System.out.println("============================================");
            System.out.println("         FINANCIAL MANAGEMENT PANEL");
            System.out.println("============================================");
            System.out.println("1. Process Income Transaction");
            System.out.println("2. Process Expense Transaction");
            System.out.println("3. Savings Goal Contribution");
            System.out.println("4. Run Financial Analysis & Reports");
            System.out.println("5. Check Dashboard Asset Net Worth");
            System.out.println("6. Return to Master Switchboard");
            int op = secureSelection("Operation Choice: ", 1, 6);

            switch (op) {
                case 1:

            }
        }

        if(panelSelection == 3) {
            System.out.println("The application has been closed!");
            System.exit(0);
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

            }catch (IllegalArgumentException e) {
                System.out.println("Invalid input!");
            }
        }
    }

    public static double secureBalance(String message) {
        while(true) {
            System.out.print(message);
            try {
                return Double.parseDouble(input.nextLine());
            }catch (NumberFormatException e) {
                System.out.println("Invalid input!");
            }
        }
    }

}