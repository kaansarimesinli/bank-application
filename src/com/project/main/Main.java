package com.project.main;

import java.util.Scanner;
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
        int selection;
        while(true) {
            System.out.print("Please select a bank: ");
            try {
                if(input.hasNextInt()) {
                    throw new IllegalArgumentException("Please enter a valid value!");
                }
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            selection = input.nextInt() - 1;
                try {
                    if(selection < 0 || selection > 3) {
                        throw new IllegalArgumentException("Please enter a valid value!");
                    }
                }catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    continue;
                }
                break;
        }
        Banks selectedBank = banks[selection];

        User newUser = new User(username, incomeAmount, recurringExpense, outstandingDebt, selectedBank);

    }

}