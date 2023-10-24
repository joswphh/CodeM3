package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MakePayment {
    public static void makePayment() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter date of transaction: YYYY-MM-DD.");
        String date = scanner.nextLine();

        System.out.println("Enter time HH:MM.");
        String time = scanner.nextLine();

        System.out.println("Enter brief description of product.");
        String description = scanner.nextLine();

        System.out.println("Enter the vendor name.");
        String vendorName = scanner.nextLine();

        System.out.println("Enter amount of what your paying.");
        double price = scanner.nextDouble();
        price = -Math.abs(price);

        scanner.nextLine();
        String fileName = "src/main/resources/transaction.csv";
        try(FileWriter fileWriter = new FileWriter(fileName, true)){
            String record  = (date + "|" + time + "|" + description + "|" + vendorName + "|" + price);
            fileWriter.write(record + System.lineSeparator());
        }
        catch(IOException ex){
            System.out.println("File not created. Error.");
        }
        System.out.println("Deposit has been made successfully. Thank you!");
    }
    }

