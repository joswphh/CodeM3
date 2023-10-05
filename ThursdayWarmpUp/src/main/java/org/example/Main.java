package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How is the weather today?: Sunny, Cloudy , Rainy ");
        String weatherAnswer =  scanner.nextLine();

        if(weatherAnswer.equalsIgnoreCase("Sunny")){
            System.out.println("It's a great day for outdoor activities!" );
        }
        else if(weatherAnswer.equalsIgnoreCase("Cloudy")){
            System.out.println("The weather is a bit uncertain.");
        }
        else if(weatherAnswer.equalsIgnoreCase("Rainy")){
            System.out.println("Don't forget your umbrella!");
        }
        else {
            System.out.println("Invalid weather type.");
        }
    }

}