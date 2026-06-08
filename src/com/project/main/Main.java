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
        double incomeAmount;
        while(true) {
            System.out.print("Please enter your income amount: ");
            try {
                incomeAmount = Double.parseDouble(input.nextLine());
                break;
            }catch (NumberFormatException e) {
                System.out.println("Invalid input!");
            }
        }
        double recurringExpense;
        while(true) {
            System.out.print("Please enter your recurring expense amount: ");
            try {
                recurringExpense = Double.parseDouble(input.nextLine());
                break;
            }catch (NumberFormatException e) {
                System.out.println("Invalid input!");
            }
        }
        double outstandingDebt;
        while(true) {
            System.out.print("Please enter your outstanding debt amount: ");
            try {
                outstandingDebt = Double.parseDouble(input.nextLine());
                break;
            }catch (NumberFormatException e) {
                System.out.println("Invalid input!");
            }
        }
        System.out.println("\nWelcome to the Financial Management Application!\n");

        System.out.println("        BANK SELECTION SCREEN");
        System.out.println("======================================");
        Banks[] banks = Banks.values();
        for(int i = 0; i < banks.length; i++) {
            System.out.printf("%d. %s%n", i + 1, banks[i].getName());
        }
        System.out.println();
        int bankSelection;
        while(true) {
                try {
                    System.out.print("Please select a bank: ");
                    int temporarySelection = Integer.parseInt(input.nextLine());

                    if(temporarySelection < 1 || temporarySelection > 4) {
                        throw new IllegalArgumentException();
                    }
                    bankSelection = temporarySelection;
                    break;

                }catch (IllegalArgumentException e) {
                    System.out.println("Invalid input!");
                }
        }
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
        int panelSelection;
        while(true) {
            try {
                System.out.print("Please select: ");
                int temporarySelection = Integer.parseInt(input.nextLine());

                if(temporarySelection < 1 || temporarySelection > 3) {
                    throw new IllegalArgumentException();
                }
                panelSelection = temporarySelection;
                break;

            }catch (IllegalArgumentException e) {
                System.out.println("Invalid input!");
            }
        }

        if(panelSelection == 3) {
            System.out.println("The application has been closed!");
            System.exit(0);
        }


    }

}