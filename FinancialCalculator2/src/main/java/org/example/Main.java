package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double initialDeposit = 0;
        double apr = 0;
        double time = 0;
        boolean validInput = false;

        System.out.println("Hello! Please enter how much your deposit will be.");
        while(!validInput) {
            if (scanner.hasNextDouble()) {
                initialDeposit = scanner.nextDouble();
                break;
            } else {
                System.out.println("Please enter a valid deposit number.");
                scanner.nextLine();
            }
        }

            System.out.println("Please enter what the interest rate is.");
            while(!validInput) {
                if (scanner.hasNextDouble()) {
                    apr = scanner.nextDouble();
                    break;
                } else {
                    System.out.println("Please enter a valid annual interest rate.");
                    scanner.nextLine();
                }
            }

            double r = apr / 100;



                System.out.println("Please enter how many years this loan will be.");
                while(!validInput) {
                    if (scanner.hasNextDouble()) {
                        time = scanner.nextDouble();
                        break;
                    } else {
                        System.out.println("Please enter a valid number of years.");
                        scanner.nextLine();
                    }
                }


                double fV = futureValue(initialDeposit, r, time);
                double totalInterestEarned = fV - initialDeposit;

        System.out.printf("The amount you will have after %.2f years is %.2f%n", time, fV);
        System.out.printf("The amount of interest earned after %.2f yaers will be %.2f", time, totalInterestEarned);

    }


    public static double futureValue(double p, double r, double t){
       double n = 365;
       return p * Math.pow(1 + r / n, n * t);
    }
}