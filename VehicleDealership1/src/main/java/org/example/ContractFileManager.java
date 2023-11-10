package org.example;

import java.io.FileWriter;
import java.io.IOException;

public class ContractFileManager {

    public static void writeCustomerInfoToFile(String sale, String date, String customerName, String customerEmail,
                                               Vehicle vehicle, double salesTax, double recordingFee, double processingFee,
                                               double total, String isFinanced, double monthlyPayment) {
        try (FileWriter writer = new FileWriter("src/main/resources/customer.txt", true)) {
            String customerInfo = "SaleType: " + sale + "|" + date + "|" + "Name: " + customerName + "|" +
                    "Email: " + customerEmail + "|" + vehicle.getVin() + "|" + vehicle.getYear() + "|" + vehicle.getMake() + "|" + vehicle.getModel() + "|" +
                    vehicle.getVehicleType() + "|" + vehicle.getColor() + "|" + "SalesTax: " + salesTax + "|" + "RecordingFee: " + recordingFee + "|" + "ProcessingFee: " + processingFee
                    + "|" + "Total: " + total + "|" + "Financed: " + isFinanced + "|" + "MonthlyPayment: " + monthlyPayment;

            writer.write(customerInfo + System.lineSeparator());
            System.out.println("Transaction written to file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error writing to the file.");
        }
    }
    public static void writeCustomerLease(String saleType, String date, String customerName, String customerEmail, Vehicle vehicle,
                                          double totalPrice, double expectedEndingValue, double leaseFee, double monthlyPayment ){
        try(FileWriter writer = new FileWriter("src/main/resources/customer.csv", true)){
            String customerInfo = "SaleType: " + saleType + "|" + date + "|" + "Name: " + customerName + "|" +
                    "Email: " + customerEmail + "|" + vehicle.getVin() + "|" + vehicle.getYear() + "|" + vehicle.getMake() + "|" + vehicle.getModel() + "|" +
                    vehicle.getVehicleType() + "|" + vehicle.getColor() + "|" + "Total: " + totalPrice +
                    "|" + "EndingValue: " + expectedEndingValue + "|" + "LeaseFee: " + leaseFee + "|" + "MonthlyPayment: " + monthlyPayment;

            writer.write(customerInfo + System.lineSeparator());
            System.out.println("Transaction written successfully to file.");
        } catch(IOException ex){
            ex.printStackTrace();
            System.out.println("Error writing to the file.");
        }

    }

}
