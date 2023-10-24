package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Ledger {
    public static void ledger() {
        Scanner scanner = new Scanner(System.in);
        boolean valid = false;
        TransactionFileReader userReader = new TransactionFileReader();

        while (!valid) {
            System.out.println("What would you like to do.");
            System.out.println("1) Display all entries.");
            System.out.println("2) Display deposits.");
            System.out.println("3) Display Payments.");
            System.out.println("4) Display Reports.");
            System.out.println("5) Back to home page. ");
            System.out.println("Please select the number 1 - 5.");
            int userChoice = scanner.nextInt();

            switch (userChoice) {
                case 1:
                    DisplayAllEntries();
                    break;
                case 2:
                    DisplayDeposits();
                    break;
                case 3:
                    DisplayPayments();
                    break;
                case 4:
                    Reports.reports();
                    break;
                case 5:
                    System.out.println("Going back to main menu.");
                    valid = true;
                    break;
            }
        }
    }

    public static void DisplayAllEntries() {
        try {
            BufferedReader transactionReader = new BufferedReader(new FileReader("src/main/resources/transaction.csv"));
            String line;
            while ((line = transactionReader.readLine()) != null) {
                System.out.println(line + "\n");
            }
            transactionReader.close();
        } catch (IOException ex) {
            System.out.println("NO");
        }

    }
    public static void DisplayDeposits() {
        try {
            BufferedReader transactionReader = new BufferedReader(new FileReader("src/main/resources/transaction.csv"));
            String line;
            while ((line = transactionReader.readLine()) != null) {
               String[] fields = line.split("\\|");

               if(fields.length == 5){
                   double amount = Double.parseDouble(fields[4].trim());
                   if (amount > 0){
                       System.out.println(line);
                   }
               }
            }
            transactionReader.close();
        } catch (IOException ex) {
            System.out.println("NO");
        }

    }
    public static void DisplayPayments() {
        try {
            BufferedReader transactionReader = new BufferedReader(new FileReader("src/main/resources/transaction.csv"));
            String line;
            while ((line = transactionReader.readLine()) != null) {
                String[] fields = line.split("\\|");

                if(fields.length == 5){
                    double amount = Double.parseDouble(fields[4].trim());
                    if (amount < 0){
                        System.out.println(line);
                    }
                }
            }
            transactionReader.close();
        } catch (IOException ex) {
            System.out.println("NO");
        }

    }



}
