package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
        System.out.println("What is your name? ");
        String name = scanner.nextLine();
        System.out.println("How many hours have you worked this week? ");
        double hoursWorked = scanner.nextDouble();
        System.out.println("What is your hourly rate? ");
        double hourlyRate = scanner.nextDouble();
        double moneyMade = PayrollCalculator(hoursWorked, hourlyRate);
        System.out.printf("Hello %s! hours worked %.2f hourly rate %.2f money made for the week %.2f",name, hoursWorked, hourlyRate, moneyMade);
    }

    public static double PayrollCalculator(double hours, double rate){
        double sum = 0;
        final double regularHoursw = 40;
        final double overtimeRate = 1.5 * rate;
        if(hours <= 40){
            sum = hours * rate;
        }
        else if(hours >= 40){
            // Math.min will return the smaller number
            // Math.max will return the higher number
            // the 0 in math.max is to keep from it being negative
            double regularHours = Math.min(hours, regularHoursw);
            double overtimeHours = Math.max(hours - regularHours, 0);
            double regular = hours * rate;
            double overtimeRates = overtimeHours * overtimeRate;
            sum = regular + overtimeRates;
        }
        return sum;
    }
}