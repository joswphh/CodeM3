package org.example;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class DealershipFileManager {

    //I think you should have a private constructor and make these methods static
    //One file manager is no different than the next
    public Dealership getDealership() {
        Dealership dealership = new Dealership("JAM's Dealership", "1234 somewhere st.", "124-123-1456");
        //How would a dealership have vehicles if you haven't loaded them from the file yet?
        ArrayList<Vehicle> vehicles = (ArrayList<Vehicle>) dealership.getAllVehicles();

        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/inventory.csv"))) {
            String fileInput;
            while ((fileInput = reader.readLine()) != null) {
                String[] fields = fileInput.split("\\|");
                if (fields.length != 8) {
                    System.out.println("Invalid data format: " + fileInput);
                    continue;
                }

                int vin = Integer.parseInt(fields[0].trim());
                int year = Integer.parseInt(fields[1].trim());
                String make = fields[2].trim();
                String model = fields[3].trim();
                String color = fields[5].trim();
                String vehicleType = fields[4].trim();
                int odometer = Integer.parseInt(fields[6].trim());
                double price = Double.parseDouble(fields[7].trim());

                Vehicle vehicle = new Vehicle(vin, year, make, model, color, vehicleType, odometer, price);
                dealership.addVehicle(vehicle);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error reading the file.");
        }

        return dealership;
    }

    public static void saveDealership(Vehicle vehicle){
        try {
            FileWriter writer = new FileWriter("src/main/resources/inventory.csv", true); // Open in append mode
            //String.format might be easier to type but this is fine too
            String csvLine = vehicle.getVin() + "|" +
                    vehicle.getYear() + "|" +
                    vehicle.getMake() + "|" +
                    vehicle.getModel() + "|" +
                    vehicle.getColor() + "|" +
                    vehicle.getVehicleType() + "|" +
                    vehicle.getOdometer() + "|" +
                    vehicle.getPrice();

            //Look at you using System.lineSeparator. Show off :P
            writer.write(csvLine + System.lineSeparator());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error writing to the file.");
        }
    }
}

// Return null if something went wrong or no data found

//Make a file input stream that points to the file that holds my vehicles

//make a scanner to take in the file input stream

//loop through the file till there is no more file

//take each row, and use the String.split() method to get your data

// create a vehicle from the array that String.split() returns

// take that vehicle and add it to the inventory list of the dealership

//after the loop is finished return dealership


