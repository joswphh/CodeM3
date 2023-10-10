package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int score =0;
        boolean valid = false;
        System.out.println("Please enter you're score");
        while(!valid){
            if(scanner.hasNextInt()){
                score = scanner.nextInt();
                break;
            }
            else{
                System.out.println("Please enter valid inout.");
                scanner.nextLine();
            }
        }

        if( score >= 90 && score <= 100){
            System.out.println("Great job you got an A!");
        }
        else if(score >= 80 && score <= 89){
            System.out.println("Great job you got a B!");
        }
        else if(score >= 70 && score <= 79){
            System.out.println("Great job you got a C!");
        }
        else if(score >= 60 && score <= 69){
            System.out.println("We have some work to do you got a D");
        }
        else if(score < 60){
            System.out.println("We have some work to do you got an F");
        }
        scanner.close();


    }
}