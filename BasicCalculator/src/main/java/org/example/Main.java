package org.example;

import java.time.Year;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the first number");
        double xValue = scanner.nextDouble();
        System.out.println("Please enter second number");
        double yValue = scanner.nextDouble();
        double answer = basicCalculator(xValue, yValue);
        //System.out.println("Please enter what arithmetic method you want");
        System.out.printf("The product of %.2f and %.2f is %.2f", xValue, yValue, answer);


    }

    public static double basicCalculator(double firstNumber, double secondNumber) {
        System.out.println("Please enter what arithmetic method you want");
        Scanner scanner = new Scanner(System.in);
        String arithmeticOption = scanner.nextLine();
        double sum = 0;
        if(arithmeticOption.equals("+")){
             sum = firstNumber + secondNumber;
            //return sum;
        }
        else if(arithmeticOption.equals("-")){
         sum = firstNumber - secondNumber;
            //return sum;
        }
        else if (arithmeticOption.equals("*")){
            sum =  firstNumber * secondNumber;
            //return sum;
        }
        else if (arithmeticOption.equals("/")){
            sum = firstNumber / secondNumber;
           // return sum;
        }
    else {
            System.out.println("you have enter an invalid operation");
        }
        return sum;
    }
}