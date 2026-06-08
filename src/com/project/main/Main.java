package com.project.main;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import com.project.model.User;
import com.project.service.api.Banks;

public class Main {

    private static final Scanner input = new Scanner(System.in);

    public static void main() {

        System.out.println("           FINANCIAL MANAGEMENT APPLICATION");
        System.out.println("=======================================================\n");
        System.out.print("Please enter your username: ");
        String username = input.nextLine();
        System.out.print("Please enter your income amount: ");
        double incomeAmount = input.nextDouble();
        System.out.print("Please enter your recurring expense amount: ");
        double recurringExpense = input.nextDouble();
        System.out.print("Please enter your outstanding debt amount: ");
        double outstandingDebt = input.nextDouble();
        System.out.println("\nWelcome to the Financial Management Application!\n");

        System.out.println("        BANK SELECTION SCREEN");
        System.out.println("======================================\n");
        Banks[] banks = Banks.values();
        for(int i = 0; i < banks.length; i++) {
            System.out.printf("%d. %s%n", i + 1, banks[i].getName());
        }
        System.out.println();
        input.nextLine();
        int selection;
        while(true) {
                try {
                    System.out.print("Please select a bank: ");
                    int temporarySelection = Integer.parseInt(input.nextLine());

                    if(temporarySelection < 0 || temporarySelection > 3) {
                        throw new IllegalArgumentException();
                    }
                    selection = temporarySelection;
                    break;

                }catch (IllegalArgumentException e) {
                    System.out.println("Invalid input!");
                }
        }
        Banks selectedBank = banks[selection];

        User newUser = new User(username, incomeAmount, recurringExpense, outstandingDebt, selectedBank);
        System.out.println("\nBank synchronization completed successfully!");
        System.out.print("Your accounts are being imported");
        try {
            for(int i = 1; i <= 3; i++) {
                TimeUnit.SECONDS.sleep(1);
                System.out.print(".");
            }
            TimeUnit.MILLISECONDS.sleep(20);
            System.out.println("\n");
            newUser.syncAccounts();
        }catch (InterruptedException e) {
            System.out.println("\nThe process was interrupted!");
        }

        newUser.getBalances();

    }

}