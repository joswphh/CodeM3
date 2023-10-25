package org.example;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class AccountingConstructors {
    private LocalDate date;
    private LocalTime time;
    private String description;
    private String vendor;
    private double amount;

    public AccountingConstructors(LocalDate date, LocalTime time, String description, String vendor, double amount) {
        this.date = date;
        this.time = time;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }
    public String getDescription() {
        return description;
    }
    public String getVendor() {
        return vendor;
    }
    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Date: " + date + ", Time: " + time + ", Description: " + description + ", Vendor: " + vendor + ", Amount: " + amount;
    }

    public static String getCorrectDate(Scanner scanner){
        while(true){
            System.out.println("Enter date of transaction: YYYY-MM-DD.");
            String dateInput = scanner.nextLine();

            if(dateInput.matches("\\d{2}:\\d{2}:\\d{2}")){
                return dateInput;
            }else {
                System.out.println("Sorry please enter date in YYYY-MM-DD format.");
            }
        }
    }
    public static String getCorrectTime(Scanner scanner) {
        while (true) {
            System.out.print("Enter time (HH:MM:SS): ");
            String timeInput = scanner.nextLine();

            if (timeInput.matches("\\d{2}:\\d{2}:\\d{2}")) {
                return timeInput;
            } else {
                System.out.println("Sorry please enter time in HH:MM:SS format.");
            }
        }
    }
}