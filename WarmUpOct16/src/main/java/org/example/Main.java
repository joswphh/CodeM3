package org.example;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] unAssortedArray = {5,4,3,2,1};
        Arrays.sort(unAssortedArray);

        for (int i : unAssortedArray) {
            System.out.println(i);
        }
    }
}
