/*
Colton Kohler
4/6/2025
M3: Programming Assignment

This program fills an ArrayList with 50 random numbers (1–20) and removes any duplicate values.
*/

import java.util.ArrayList;
import java.util.Random;

public class RemoveDuplicatesTest {

    public static void main(String[] args) {
        // Create and fill the original ArrayList with 50 random numbers (1-20)
        ArrayList<Integer> originalList = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < 50; i++) {
            originalList.add(rand.nextInt(20) + 1); // random number between 1 and 20
        }

        // Print the original list
        System.out.println("Original List:");
        System.out.println(originalList);

        // Remove duplicates
        ArrayList<Integer> uniqueList = removeDuplicates(originalList);

        // Print the list without duplicates
        System.out.println("\nList Without Duplicates:");
        System.out.println(uniqueList);
    }

    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        ArrayList<E> newList = new ArrayList<>();

        for (E element : list) {
            if (!newList.contains(element)) {
                newList.add(element);
            }
        }

        return newList;
    }
}
