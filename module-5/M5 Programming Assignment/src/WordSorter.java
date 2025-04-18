/*
Colton Kohler
4/13/2025
M5 Programming Assignment

This program reads words from a file, removes duplicates, and displays them in ascending and descending order.
*/

import java.util.*;
import java.io.*;

public class WordSorter {
    public static void main(String[] args) {
        // Create a TreeSet to automatically store unique words in ascending order
        TreeSet<String> words = new TreeSet<>();

        try {
            // Read from the file
            File file = new File("collection_of_words.txt");
            Scanner input = new Scanner(file);

            // Add each full line to the TreeSet (nextLine instead of next)
            while (input.hasNextLine()) {
                String line = input.nextLine().trim(); // Remove any extra spaces
                if (!line.isEmpty()) { // Only add non-empty lines
                    words.add(line);
                }
            }
            input.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Please make sure collection_of_words.txt is in the correct location.");
            return;
        }

        // Display words in ascending order
        System.out.println("Words in ascending order:");
        for (String word : words) {
            System.out.println(word);
        }

        // Display words in descending order
        System.out.println("\nWords in descending order:");
        Iterator<String> descendingIterator = words.descendingIterator();
        while (descendingIterator.hasNext()) {
            System.out.println(descendingIterator.next());
        }
    }
}
