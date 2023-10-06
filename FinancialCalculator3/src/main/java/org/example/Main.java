package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double monthlyPayout = 0;
        double interestRate = 0;
        double timeYears = 0;
        boolean valid = false;

        System.out.println("Hello! What would you like to deposit monthyly?");
        while(!valid){
            if(scanner.hasNextDouble()){
                monthlyPayout = scanner.nextDouble();
                break;
            }
            else{
                System.out.println("Please input valid monthly deposit.");
                scanner.nextLine();
            }
            }

        System.out.println("What is your expected interest rate?");
        while(!valid) {
            if (scanner.hasNextDouble()) {
                interestRate = scanner.nextDouble();
                break;
            } else {
                System.out.println("Please input valid interest rate number.");
                scanner.nextLine();
            }
        }


            System.out.println("How many years will this be in the account for?");
            while(!valid) {
                if (scanner.hasNextDouble()) {
                    timeYears = scanner.nextDouble();
                    break;
                } else {
                    System.out.println("Please input valid amount of years.");
                    scanner.nextLine();
                }
            }

                double payments = timeYears * 12;

                double finalCalculation = monthlyFinance(monthlyPayout, interestRate, payments);
        System.out.printf("The amount of money you will have in this account after %.2f years is %.2f", timeYears, finalCalculation);
    }

    public static double monthlyFinance(double pmt, double r, double n){
        double rRate = r / 12 / 100;
        return pmt * ((1-Math.pow(1 + rRate, - n)) / (rRate));
    }
}