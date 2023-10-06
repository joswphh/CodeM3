package org.example;

import java.nio.file.FileSystemNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //inputs
        double principle = 0;
        double loanLength = 0;
        double interestRate = 0;
        // double monthlyPayment= 0;
        boolean validInput = false;

        //souts
        System.out.println("Hello there");
        System.out.println("Please enter the amount you would like to finance. ");
        while (!validInput) {
            if (scanner.hasNextDouble()) {
                principle = scanner.nextDouble();
                break;
            } else {
                System.out.println("You have entered a wrong input. Please try again");
               scanner.nextLine();
            }
        }

        System.out.println("What interest rate would you like to use?");
        while (!validInput) {
            scanner.nextLine();
            if (scanner.hasNextDouble()) {
                interestRate = scanner.nextDouble();
                break;
            } else {
                System.out.println("You have entered a invalid interest rate. Please try again.");

            }
        }

        double r = interestRate / 12 / 100;

        System.out.println("How many years would you like to be?");
        while (!validInput) {
            if (scanner.hasNextDouble()) {
                loanLength = scanner.nextDouble();
                break;
            } else {
                System.out.println("You have entered an invalid loan length. Please try again.");
                scanner.nextLine();
            }

        }

        double n = loanLength * 12;
        double monthlyPayments = mortgageCalculator(principle, r, n);
        double totalInterest = (monthlyPayments * n) - principle;

        // calc # 2


        //souts for final product
        System.out.printf("You're total monthly payment will be: $%.2f%n", monthlyPayments);
        System.out.printf("Total amount of interest paid: $%.2f%n", totalInterest);

    }

    public static double mortgageCalculator(double p, double r, double n) {
        double numerator = p * r * Math.pow(1 + r, n);
        double denominator = Math.pow(1 + r, n) - 1;
        return numerator / denominator;

    }
}

