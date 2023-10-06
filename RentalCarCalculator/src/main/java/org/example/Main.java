package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello! what date would you like to rent this vehicle ");
        String pickUpDate = scanner.nextLine();
        System.out.println("How many days would you like this car for?");
        double amountOfDays = scanner.nextDouble();
        double basicRate = 29.99;
        double tollTag = 3.95;
        double gps = 2.95;
        double roadSide = 3.95;
        double surcharge = 1.30;
        System.out.println("Would you like an electronic Toll tag. It will be 3.95 a day. Please answer yes or no.");
        scanner.nextLine();
        String answerToll = scanner.nextLine();
        double finalToll = TollTag(tollTag, answerToll);
        System.out.println("would you like GPS? It will be 2.95 a day. Please answer yes or no");
        String answerGps = scanner.nextLine();
        double finalGps = Gps(gps, answerGps);
        System.out.println("would you like road side assistance? It will be 3.95 per day. Please answer yes or no");
        String answerRoad = scanner.nextLine();
         double finalRoad = RoadSide(roadSide, answerRoad);
        System.out.println("How old are you?");
        double answerAge = scanner.nextDouble();
        //double finalAge = Surcharge(surcharge, answerAge);
        double finalRate = basicRate + finalToll + finalRoad + finalGps;
        double totalAlmost = finalRate * amountOfDays;
        double totalCost = Surcharge(surcharge, totalAlmost, answerAge);

        System.out.printf("Basic price per day: $%.2f. Toll tag per day: $%.2f. road assistance per day: $%.2f. Gps per day: $%.2f", basicRate, finalToll, finalRoad, finalGps);
        System.out.println("");
        System.out.printf("On the date %s the final price will be: %.2f", pickUpDate, totalCost);
        //System.out.println();
        scanner.close();
    }

    public static double TollTag(double tollTag, String answerToll) {
        double sum;
        if (answerToll.equalsIgnoreCase("yes")) {
            sum = tollTag;
        } else {
            sum = 0;
        }
        return sum;
    }

    public static double Gps(double gps, String answerGps) {
        double sum;
        if (answerGps.equalsIgnoreCase("Yes")) {
            sum = gps;
        } else {
            sum = 0;
        }
        return sum;

    }

    public static double RoadSide(double roadSide, String answerRoad) {
        double sum;
        if (answerRoad.equalsIgnoreCase("yes")) {
            sum = roadSide;
        } else {
            sum = 0;
        }
        return sum;
    }
    public static double Surcharge(double surcharge, double amount, double answerAge){
        double sum = 1;
        if(answerAge <= 25){
            sum = surcharge * amount;
        }
        else if(answerAge > 25){
            sum = amount * 1;
        }
        return sum;
    }

}