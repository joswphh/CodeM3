package org.example;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);
            boolean valid = false;
            while (!valid) {
                try{
                System.out.println("Hello welcome to JAM's Ledger");
                System.out.println("What are you visiting us today for.");
                System.out.println("1) Add deposit");
                System.out.println("2) Make payment (Debit)");
                System.out.println("3) View ledger");
                System.out.println("4) Exit");

                int userChoice = scanner.nextInt();

                switch (userChoice){
                    case 1:
                        AddDeposit.addDeposit();
                        break;
                    case 2:
                        MakePayment.makePayment();
                        break;
                    case 3:
                        Ledger.ledger();
                        break;
                    case 4:
                        System.out.println("See you next time. Have a good day!");
                        System.exit(0);
                        break;
                }
            }
                catch(NumberFormatException ex){
                    System.out.println("Wrong input please try again.");
                }
                catch(InputMismatchException e){
                    System.out.println("Please try again wrong input.");
                    scanner.nextLine();
                }
        }

    }
}