package org.example;

//You clearly understand separation of concerns and you understand that each
//class has its own responsibility.
//My only comments are on small things like DealershipFileManager having static methods
//And little small places where you create variables you don't use.
//All in all, excellent work.
public class Main {
    public static void main(String[] args) {
        UserInterface user = new UserInterface();
        user.userInterface();
    }
}
