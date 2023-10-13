package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Book[] library = new Book[20];

        library[0] = new Book(1235, "3265", "Building Cars", false, "Author A");
        library[1] = new Book(4567, "289", "Cooking Recipes", false, "Author B");
        library[2] = new Book(7890, "543", "Java Programming", false, "Author C");
        library[3] = new Book(9876, "123", "History of Art", false, "Author D");
        library[4] = new Book(5432, "765", "Science Fiction", false, "Author E");
        library[5] = new Book(1111, "432", "Mystery Novels", false, "Author F");
        library[6] = new Book(2222, "567", "Travel Adventures", false, "Author G");
        library[7] = new Book(3333, "987", "Poetry Collection", false, "Author H");
        library[8] = new Book(4444, "222", "Self-Help Guide", false, "Author I");
        library[9] = new Book(5555, "654", "Fantasy World", false, "Author J");
        library[10] = new Book(6666, "567", "Educational Tools", false, "Author K");
        library[11] = new Book(7777, "987", "Biography", false, "Author L");
        library[12] = new Book(8888, "222", "Nature Exploration", false, "Author M");
        library[13] = new Book(9999, "654", "Science and Technology", false, "Author N");
        library[14] = new Book(1010, "567", "Romantic Novels", false, "Author O");
        library[15] = new Book(2020, "987", "Business Strategies", false, "Author P");
        library[16] = new Book(3030, "222", "Health and Wellness", false, "Author Q");
        library[17] = new Book(4040, "654", "Philosophy", false, "Author R");
        library[18] = new Book(5050, "567", "Historical Fiction", false, "Author S");
        library[19] = new Book(6060, "987", "Art of Cooking", false, "Author T");

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please select what you would like to do.");
            System.out.println("1) Show available books");
            System.out.println("2) Show checked out books or check in books");
            System.out.println("3) Exit the program");
            int userInput = scanner.nextInt();

            switch (userInput) {
                case 1:
                    showAvailableBooks(library);
                    break;
                case 2:
                    displayAvailableBooks(library);
                    break;


            }
        }


    }


    public static void showAvailableBooks(Book[] books) {
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;
        boolean notCheckedOut = false;
        for (Book book : books) {
            if (book != null && !book.isCheckedOut()) {
                System.out.println("Book ID: " + book.getId() + " Book ISBN: " + book.getIsbn() + " Book Title: " + book.getTitle());
                notCheckedOut = true;
            }
        }
        if (!notCheckedOut) {
            System.out.println("No books available right now");
        }

        while (!validInput) {
            System.out.println("Select 1 of the following options");
            System.out.println(" 1) Check out a book.");
            System.out.println(" 2) Exit the program");
            int userInput = scanner.nextInt();
            scanner.nextLine();
            switch (userInput) {
                case 1:
                    System.out.println("Please enter your name.");
                    String bookName = scanner.nextLine();
                    System.out.println("Please select the book you would like to check out by entering it's ID");
                    int bookID = scanner.nextInt();
                    for (Book library : books) {
                        if (library != null && library.getId() == bookID) {
                            library.setCheckedOut(true);
                            library.setCheckedOutTo(bookName);
                            System.out.println(library.getTitle() + " is checked out by " + bookName);
                        }
                    }
                    validInput = true;
                    break;
                case 2:
                    System.out.println("You're heading to the main menu");
                    validInput = true;
                    break;

                default:
                    System.out.println("You've entered incorrect input try again");
                    break;
            }


        }
    }

    public static void displayAvailableBooks(Book[] books) {
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;
        boolean notCheckedOut = false;
        for (Book book : books) {
            if (book.isCheckedOut()) {
                System.out.println("Book ID: " + book.getId() + " Book ISBN: " + book.getIsbn() + " Book Title: " + book.getTitle() + " Checked out by: " + book.getCheckedOutTo());
                book.setCheckedOut(false);
                notCheckedOut = true;
                break;
            }
        }
        if(!notCheckedOut){
            System.out.println("There are no books currently checked out.");
        }

        while (!validInput){
            System.out.println("Select 1 of the following options");
            System.out.println( " 1) Check a book in.");
            System.out.println( " 2) Go back to home screen.");
            int userInput = scanner.nextInt();

            switch (userInput){

                case 1:
                    System.out.println("Please enter the book ID of the book your checking in.");
                    int returnID = scanner.nextInt();
                    for ( Book library : books){
                        if(library.getId() == returnID && library.isCheckedOut()){
                            library.setCheckedOut(false);
                            System.out.println("Book checked in successfully!");
                        }
                        else if(library.getId() != returnID && library.isCheckedOut()){
                            System.out.println(" Your book ID is wrong");
                        }
                    }
                case 2:
                    System.out.println("You're heading to the main menu");
                    validInput = true;
                    break;

                default:
                    System.out.println("You've entered incorrect input try again");
                    break;


        }
    }

    }
}
