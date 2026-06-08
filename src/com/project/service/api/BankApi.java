package com.project.service.api;

import java.util.Scanner;

public class BankApi {

    public static Scanner scanner = new Scanner(System.in);

    public static void bankSelectionScreen() {
        System.out.println("\t\t\t\tBANKS");
        System.out.println("=====================================");
        int count = 1;
        for(Banks banks : Banks.values()) {
            System.out.printf("%d - %s%n", count, banks.getName());
            count++;
        }
        System.out.printf("%n%s", "Please select a bank: ");
        int selection = scanner.nextInt();
        accountSelectionScreen();
    }

    private static void accountSelectionScreen() {
        System.out.println("\tACCOUNTS\n");
        int count = 1;
        for(Accounts acc : Accounts.values()) {
            System.out.printf("%d - %s : %.1f%n", count, acc.getName(), acc.getBalance());
            count++;
        }
    }


}
