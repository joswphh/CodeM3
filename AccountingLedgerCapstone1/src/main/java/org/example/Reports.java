package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

public class Reports {
    public static void reports() {
        boolean valid = false;


        while (!valid) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("What would you like to do?");
            System.out.println("1) Search by Month to Date.");
            System.out.println("2) Search by Previous Month.");
            System.out.println("3) Search by Year to Date.");
            System.out.println("4) Search by Previous Year.");
            System.out.println("5) Search by Vendor.");
            System.out.println("6) Custom Search.");
            System.out.println("7) Back to the previous screen.");
            System.out.println("Please input a number 1 - 7");
            int userChoice = 0;
            if(scanner.hasNextInt()){
                userChoice = scanner.nextInt();
            }
            else{
                System.out.println("Invalid input. Please try again.");
                scanner.next();
            }

            switch (userChoice) {
                case 1:
                    sortTransactionsByDate();
                    break;
                case 2:
                    sortByPreviousMonth();
                    break;
                case 3:
                    yearToDate();
                    break;
                case 4:
                    previousYear();
                    break;
                case 5:
                    searchByVendor();
                    break;
                case 6:
                    customSearch();
                    break;
                case 7:
                    System.out.println("Going back to the previous screen.");
                    valid = true;
                    break;
            }
        }
    }

   public static ArrayList<AccountingConstructors> transaction = transactions();

    public static ArrayList<AccountingConstructors> transactions() {
        ArrayList<AccountingConstructors> transaction = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader("src/main/resources/transaction.csv");

            BufferedReader bf = new BufferedReader(fileReader);
            String fileInput;
            while ((fileInput = bf.readLine()) != null) {
                String[] fields = fileInput.split("\\|");
                LocalDate date = LocalDate.parse(fields[0].trim());
                LocalTime time = LocalTime.parse(fields[1].trim());
                String description = fields[2].trim();
                String vendor = fields[3].trim();
                double amount = Double.parseDouble(fields[4].trim());

                AccountingConstructors newTransaction = new AccountingConstructors(date, time, description, vendor, amount);
                transaction.add(newTransaction);
            }
            bf.close();
        } catch (IOException ex) {
            System.out.println("Error writing the file.");
        }
        return transaction;
    }
    public static void sortTransactionsByDate() {
        //declaring the list-
        List<AccountingConstructors> transactions = transactions();

        // Sort transactions by date using Collections.sort
        transactions.sort(Comparator.comparing(AccountingConstructors::getDate));
        // Display the sorted transactions
        for (AccountingConstructors transaction : transactions) {
            System.out.println(transaction);
        }
    }

    public static void sortByPreviousMonth(){
        List<AccountingConstructors> transactions = transactions();
        //getting the current date
        LocalDate currentDate = LocalDate.now();
        //Calculating the date for the start of the previous month
        LocalDate firstDayOfPreviousMonth = LocalDate.now().minusMonths(1).withDayOfMonth(1);
        //Calculating the start of the current month
        LocalDate firstDayOFCurrentMonth = currentDate.withDayOfMonth(1);
        //filtering previous months transactions
        //stream allows for further processing using stream operators
        //stream in this case takes the block of code which is getting previous
        // month transactions and filters everything else out
        List<AccountingConstructors> previousMonthTransactions =
                transactions.stream().filter(transaction ->{
            LocalDate transactionDate = transaction.getDate();
            //both need to be true in order to pass and filter out previous month transactions
            return transactionDate.isAfter(firstDayOfPreviousMonth) &&
                    transactionDate.isBefore(firstDayOFCurrentMonth);
        })
                        //ends the filter operation and collects the info
                        .toList();
        //displaying last month transactions
        for(AccountingConstructors transaction: previousMonthTransactions){
            System.out.println(transaction);
        }
    }

    public static void yearToDate(){
        List<AccountingConstructors> transactions = transactions();
        LocalDate currentDate = LocalDate.now();
        LocalDate firstDayOfCurrentYear = LocalDate.of(currentDate.getYear(), 1,1);

        List<AccountingConstructors> yearToDateTransactions = transactions.stream().filter(transaction->{
            LocalDate transactionDate = transaction.getDate();
            return !transactionDate.isBefore(firstDayOfCurrentYear) && !transactionDate.isAfter(currentDate);
        })
                .toList();
        for(AccountingConstructors transaction : yearToDateTransactions){
            System.out.println(transaction);
        }
    }

    public static void previousYear(){
        List<AccountingConstructors> transactions = transactions();

        LocalDate currentDate = LocalDate.now();
        LocalDate firstDayOfPreviousYear = currentDate.minusYears(1).withDayOfYear(1);
        LocalDate lastDayOfPreviousYear =
                currentDate.minusYears(1).withDayOfYear(currentDate.minusYears(1).lengthOfYear());

        List<AccountingConstructors> previousYearTransactions = transactions.stream().filter(transaction ->{
            LocalDate transactionDate = transaction.getDate();
            return transactionDate.isAfter(firstDayOfPreviousYear) && transactionDate.isBefore(lastDayOfPreviousYear);
        })
                .toList();
        for(AccountingConstructors transaction : previousYearTransactions){
            System.out.println(transaction);
        }
    }

    public static void searchByVendor(){
        List<AccountingConstructors> transactions = transactions();
        Scanner scanner = new Scanner(System.in);
        System.out.println("What vendor would you like to search by");
        String userVendor = scanner.nextLine();
        boolean equals = false;

        for(AccountingConstructors transaction : transactions){
            if(userVendor.equalsIgnoreCase(transaction.getVendor())){
                System.out.println(transaction);
                equals = true;
            }
            else if(!equals){
                System.out.println("Vendor not found");
            }
        }
    }

    public static void customSearch(){
        System.out.println("Enter the following information please.");
        Scanner scanner = new Scanner(System.in);

        LocalDate userStartDate = null;
        LocalDate userEndDate = null;
        String userDescription = null;
        String userVendor = null;
        double userAmount = 0.0;

        System.out.println("Enter the start date of your search in format YYYY-MM-DD");
        String startDateInput = scanner.nextLine();
        if(!startDateInput.isEmpty()){
            userStartDate = LocalDate.parse(startDateInput);
        }
        System.out.println("Enter the start end of your search in format YYYY-MM-DD");
        String endDateInput = scanner.nextLine();
        if(!endDateInput.isEmpty()){
            userEndDate = LocalDate.parse(endDateInput);
        }
        System.out.println("Enter the product description.");
        String descriptionInput = scanner.nextLine();
        if(!descriptionInput.isEmpty()){
            userDescription = descriptionInput;
        }
        System.out.println("Enter the vendor.");
        String vendorInput = scanner.nextLine();
        if(!vendorInput.isEmpty()){
            userVendor = vendorInput;
        }
        System.out.println("Enter the amount");
        String amountInput = scanner.nextLine();
        if(!amountInput.isEmpty()){
            try{
                userAmount = Double.parseDouble(amountInput);
            }catch (NumberFormatException ex){
                System.out.println("Invalid format. Please try again.");
            }
        }
        performCustomSearch(userStartDate,userEndDate,userDescription,userVendor,userAmount);
    }
    public static void performCustomSearch(LocalDate startDate, LocalDate endDate, String description, String vendor, double amount) {
        List<AccountingConstructors> transactions = transactions();
        List<AccountingConstructors> filteredList = transactions.stream()
                .filter(transaction -> (startDate == null || transaction.getDate().isAfter(startDate) || transaction.getDate().isEqual(startDate)))
                .filter(transaction -> (endDate == null || transaction.getDate().isBefore(endDate) || transaction.getDate().isEqual(endDate)))
                .filter(transaction -> (description == null || transaction.getDescription().equalsIgnoreCase(description)))
                .filter(transaction -> (vendor == null || transaction.getVendor().equalsIgnoreCase(vendor)))
                .filter(transaction -> (amount == 0.0 || transaction.getAmount() == amount))
                .toList();

        // Display the filtered list
        for (AccountingConstructors transaction : filteredList) {
            System.out.println(transaction);
        }
    }
}


