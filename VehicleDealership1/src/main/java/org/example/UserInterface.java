package org.example;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    Dealership dealership = new Dealership("JAM's Dealership", "1234 somewhere st.", "124-123-1456");

    public void user() {
        init();
    }

    private void init() {
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        this.dealership = dealershipFileManager.getDealership();
    }

    public void userInterface() {
        init();
        boolean valid = false;
        Scanner scanner = new Scanner(System.in);

        while (!valid) {
            display();
            int userChoice = 0;
            if (scanner.hasNextInt()) {
                userChoice = scanner.nextInt();
            } else {
                System.out.println("Please try again. Incorrect choice.");
                scanner.nextLine();
            }
            switch (userChoice) {
                case 1:
                    processByPriceRequest();
                    break;
                case 2:
                    processByMakeModelRequest();
                    break;
                case 3:
                    processByYearRequest();
                    break;
                case 4:
                    processByColorRequest();
                    break;
                case 5:
                    processByMileageRequest();
                    break;
                case 6:
                    processByVehicleTypeRequest();
                    break;
                case 7:
                    processAllVehiclesRequest();
                    break;
                case 8:
                    processAddVehicleRequest();
                    DealershipFileManager.saveDealership(dealership);
                    break;
                case 9:
                    processRemoveVehicleRequest();
                    DealershipFileManager.saveDealership(dealership);
                    break;
                case 10:
                    processBuyVehicle();
                    DealershipFileManager.saveDealership(dealership);
                    break;
                case 11:
                    processLeaseVehicle();
                    DealershipFileManager.saveDealership(dealership);
                    break;
                case 99:
                    System.out.println("Thank you see you later.");
                    System.exit(0);
                default:
                    System.out.println("Please try again.");
            }
        }
    }

    private void display() {
        System.out.println("1) Find vehicles within a price range.");
        System.out.println("2) Find vehicle by make / model.");
        System.out.println("3) Find vehicle by year range.");
        System.out.println("4) Find vehicles by color.");
        System.out.println("5) Find vehicle by mileage range.");
        System.out.println("6) Find vehicle by type (car,truck,SUV, van).");
        System.out.println("7) List all vehicles.");
        System.out.println("8) Add vehicle.");
        System.out.println("9) Remove vehicle.");
        System.out.println("10) Buy a Vehicle");
        System.out.println("11) Lease a vehicle");
        System.out.println("99) Exit");
        System.out.print("Please enter your choice: ");
    }

    private void displayVehicles(List<Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles) {
            System.out.println("VIN: " + vehicle.getVin());
            System.out.println("Year: " + vehicle.getYear());
            System.out.println("Make: " + vehicle.getMake());
            System.out.println("Model: " + vehicle.getModel());
            System.out.println("Color: " + vehicle.getColor());
            System.out.println("Type: " + vehicle.getVehicleType());
            System.out.println("Odometer: " + vehicle.getOdometer() + " miles");
            System.out.println("Price: $" + vehicle.getPrice());
            System.out.println();
        }

    }

    private void processAllVehiclesRequest() {
        List<Vehicle> vehicles = dealership.getAllVehicles();
        System.out.println("Number of vehicles: " + vehicles.size());
        displayVehicles(vehicles);
    }

    private void processByPriceRequest() {
        double minPrice = 0;
        double maxPrice = 0;
        System.out.println("Enter minimum price: ");
        if (scanner.hasNextDouble()) {
            minPrice = scanner.nextDouble();
        } else {
            System.out.println("Invalid input. Please enter a valid number.");
        }
        scanner.nextLine();

        System.out.println("Enter maximum price.");
        if (scanner.hasNextDouble()) {
            maxPrice = scanner.nextDouble();
        } else {
            System.out.println("Invalid input. Please enter a valid number.");
        }
        List<Vehicle> vehicles = dealership.getVehicleByPrice(minPrice, maxPrice);

        if (vehicles.isEmpty()) {
            System.out.println("No vehicles found within this price range.");
        } else {
            System.out.println("Vehicles within price range.");
            displayVehicles(vehicles);
        }

    }

    private void processByMakeModelRequest() {
        String make = null;
        String model = null;
        System.out.println("Searching by make and model.");

        System.out.println("Enter the make please.");
        if (scanner.hasNextLine()) {
            make = scanner.nextLine();
        } else {
            System.out.println("Invalid input. Please enter a valid make.");
        }

        System.out.println("Enter the model please.");
        if (scanner.hasNextLine()) {
            model = scanner.nextLine();
        } else {
            System.out.println("Invalid input. Please enter a valid model.");
        }
        List<Vehicle> vehicles = dealership.getVehicles(make, model);
        if (vehicles.isEmpty()) {
            System.out.println("No vehicle of this make and model found.");
        } else {
            System.out.println("Vehicles with that make and model.");
            displayVehicles(vehicles);
        }

    }

    private void processByYearRequest() {
        double minYear = 0;
        double maxYear = 0;
        System.out.println("Please enter the minimum year.");
        if (scanner.hasNextDouble()) {
            minYear = scanner.nextDouble();
        } else {
            System.out.println("Invalid input. Please enter a valid number.");
        }

        System.out.println("Please enter the max year");
        if (scanner.hasNextDouble()) {
            maxYear = scanner.nextDouble();
        } else {
            System.out.println("Invalid input. Please enter a valid number.");
        }
        List<Vehicle> vehicles = dealership.getByYear(minYear, maxYear);
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles within these years found.");
        } else {
            System.out.println("Vehicles within these years found.");
            displayVehicles(vehicles);
        }

    }

    private void processByColorRequest() {
        String color = null;
        System.out.println("What color would you like to search by?");
        if (scanner.hasNextLine()) {
            color = scanner.nextLine();
        } else {
            System.out.println("Invalid input. Please enter a valid color.");
        }
        List<Vehicle> vehicles = dealership.getByColor(color);
        if (vehicles.isEmpty()) {
            System.out.println("There is no vehicles with this color.");
        } else {
            System.out.printf("Vehicles with %s color: %n", color);
            displayVehicles(vehicles);
        }
    }

    private void processByMileageRequest() {
        double minMiles = 0;
        double maxMiles = 0;

        System.out.println("What is the minimum number of miles?");
        if (scanner.hasNextDouble()) {
            minMiles = scanner.nextDouble();
        } else {
            System.out.println("Invalid input. Please enter a valid number.");
        }

        System.out.println("What is the maximum number of miles?");
        if (scanner.hasNextDouble()) {
            maxMiles = scanner.nextDouble();
        } else {
            System.out.println("Invalid input. Please enter a valid number.");
        }
        List<Vehicle> vehicles = dealership.getVehicleByMileage(minMiles, maxMiles);
        if (vehicles.isEmpty()) {
            System.out.println("There are no vehicles with those miles");
        } else {
            System.out.println("Here are the vehicles with those miles");
            displayVehicles(vehicles);
        }

    }

    private void processByVehicleTypeRequest() {
        String vehicleType = null;
        System.out.println("What is the vehicle type you would like to search by? (SUV,Truck,Car)");
        if (scanner.hasNextLine()) {
            vehicleType = scanner.nextLine();
        } else {
            System.out.println("Invalid input. Please enter a valid vehicle type.");
        }
        System.out.println(vehicleType);

        List<Vehicle> vehicles = dealership.getVehicleByType(vehicleType);
        if (vehicles.isEmpty()) {
            System.out.println("There are no vehicles of that type.");
        } else {
            System.out.println("Here are the vehicles of that type.");
            displayVehicles(vehicles);
        }
    }

    private void processAddVehicleRequest() {

        System.out.println("Adding a new vehicle:");

        System.out.print("Enter VIN: ");
        int vin = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Year: ");
        int year = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Make: ");
        String make = scanner.nextLine();

        System.out.print("Enter Model: ");
        String model = scanner.nextLine();

        System.out.print("Enter Color: ");
        String color = scanner.nextLine();

        System.out.print("Enter Vehicle Type: ");
        String vehicleType = scanner.nextLine();

        System.out.print("Enter Odometer: ");
        int odometer = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        Vehicle newVehicle = new Vehicle(vin, year, make, model, color, vehicleType, odometer, price);
        dealership.addVehicle(newVehicle);
        System.out.println("New vehicle added successfully!");

    }

    private void processRemoveVehicleRequest() {
        System.out.println("Removing a vehicle.");

        System.out.println("Enter the vin of the car you would like to remove.");
        if (scanner.hasNextInt()) {
            int vinToRemove = scanner.nextInt();
            boolean removed = false;

            List<Vehicle> vehicles = dealership.getAllVehicles();
            for (Vehicle vehicle : vehicles) {
                if (vehicle.getVin() == vinToRemove) {
                    dealership.removeVehicle(vehicle);
                    System.out.println("Removed vehicle with VIN " + vinToRemove);
                    removed = true;
                    break;
                }
            }

            if (!removed) {
                System.out.println("No vehicle found with VIN " + vinToRemove);
            }
        } else {
            System.out.println("Invalid VIN. Please try again.");
        }

    }


    private void processBuyVehicle() {
        System.out.println("You are purchasing a vehicle");
        boolean isFinanced = false;
        // vinFound avoids purchasing if VIN is not found
        boolean vinFound = false;
        String choice = null;

        System.out.println("Please enter the VIN of the car you would like to buy");
        if (scanner.hasNextInt()) {
            int vinToSearchBy = scanner.nextInt();
            scanner.nextLine(); // consume the newline

            System.out.println("Would you like to finance? (Yes / No)");
            if (scanner.hasNextLine()) {
                choice = scanner.nextLine();
                if (choice.equalsIgnoreCase("yes")) {
                    isFinanced = true;
                } else if (choice.equalsIgnoreCase("no")) {
                    isFinanced = false;
                } else {
                    System.out.println("Invalid answer. Please enter yes or no.");
                    return; // return to the main screen if the answer is invalid
                }
            }

            System.out.println("PLease enter the following information");
            System.out.println("Please enter the date.");
            String date = scanner.nextLine();
            System.out.println("Please enter your name");
            String customerName = scanner.nextLine();
            System.out.println("Please enter your email");
            String customerEmail = scanner.nextLine();

            List<Vehicle> vehicles = dealership.getAllVehicles();
            for (Vehicle vehicle : vehicles) {
                if (vinToSearchBy == vehicle.getVin()) {
                    vinFound = true;
                    SalesContract salesContract = new SalesContract(date, customerName, customerEmail, vehicle, isFinanced);
                    salesContract.getTotalPrice();
                    salesContract.getMonthlyPayment();
                    System.out.printf("Your Total Price will be: %.2f %n", salesContract.getTotalPrice());
                    System.out.printf("Your monthly payment will be %.2f %n", salesContract.getMonthlyPayment());

                    System.out.println("Would you like to buy it?");
                    if (scanner.hasNextLine()) {
                        String buyChoice = scanner.nextLine();
                        if (buyChoice.equalsIgnoreCase("yes")) {
                            dealership.removeVehicle(vehicle);
                            System.out.println("Removed vehicle with VIN " + vinToSearchBy);
                            ContractFileManager.writeCustomerInfoToFile("SALE", date, customerName, customerEmail, vehicle, salesContract.salesTax(), salesContract.recordingFee(),
                                    salesContract.processingFee(), salesContract.getTotalPrice(), choice, salesContract.getMonthlyPayment());
                            System.out.println("Car successfully purchased. CONGRATS!!!");
                        } else {
                            System.out.println("Contract Rejected. Returning back to the main screen.");
                        }
                    }
                    break; // exit the loop once the VIN is found
                }
            }

            if (!vinFound) {
                System.out.println("Vin not found. Returning to the main screen.");
            }
        } else {
            System.out.println("Invalid input. Please enter a valid VIN.");
        }
    }


    public void processLeaseVehicle() {
        boolean vinFound = false;

        System.out.println("You are leasing a vehicle");
        System.out.println("Enter the VIN of the vehicle");

        if (scanner.hasNextInt()) {
            int vinToSearchBy = scanner.nextInt();
            scanner.nextLine(); // consume the newline

            System.out.println("Please enter the following information.");
            System.out.println("Please enter the date.");
            String date = scanner.nextLine();
            System.out.println("Please enter your name");
            String customerName = scanner.nextLine();
            System.out.println("Please enter your email");
            String customerEmail = scanner.nextLine();

            List<Vehicle> vehicles = dealership.getAllVehicles();
            Iterator<Vehicle> iterator = vehicles.iterator();

            while (iterator.hasNext()) {
                Vehicle vehicle = iterator.next();

                if (vinToSearchBy == vehicle.getVin()) {
                    vinFound = true;
                    LeaseContract leaseContract = new LeaseContract(date, customerName, customerEmail, vehicle);
                    leaseContract.getTotalPrice();
                    leaseContract.getMonthlyPayment();

                    System.out.printf("Your total price will be: %.2f %n", leaseContract.getTotalPrice());
                    System.out.printf("Your monthly payment will be: %.2f %n", leaseContract.getMonthlyPayment());

                    System.out.println("Would you like to lease the vehicle? (Yes / No)");
                    if (scanner.hasNextLine()) {
                        String userLeaseChoice = scanner.nextLine();
                        if (userLeaseChoice.equalsIgnoreCase("yes")) {
                            ContractFileManager.writeCustomerLease("LEASE", date, customerName, customerEmail, vehicle, leaseContract.getTotalPrice(),
                                    leaseContract.expectedEndingValue(), leaseContract.leaseFee(), leaseContract.getMonthlyPayment());
                            System.out.println("Car successfully leased. CONGRATS!!!");
                            iterator.remove(); // remove the current vehicle using iterator
                        } else {
                            System.out.println("Lease Declined. Return to the main page");
                        }
                    }
                }
            }

            if (!vinFound) {
                System.out.println("Vin not found. Returning to the main screen.");
            }
        } else {
            System.out.println("Invalid input. Please enter a valid VIN.");
        }
    }


}
