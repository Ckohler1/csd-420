/*
Colton Kohler
4/17/2025
M6 Programming Assignment

This program defines a custom TShirt class and uses two bubble sort methods to sort an array:
one using the Comparable interface (by size) and the other using a Comparator (by color).
*/

import java.util.Comparator;

public class BubbleSortTShirts {

    public static void main(String[] args) {
        // Create a larger test array of TShirts with more variety
        TShirt[] shirts = {
                new TShirt("Small", "Red"),
                new TShirt("Medium", "Blue"),
                new TShirt("Large", "Green"),
                new TShirt("XL", "Black"),
                new TShirt("XXL", "White"),
                new TShirt("Small", "Blue"),
                new TShirt("Medium", "Red"),
                new TShirt("Large", "Black"),
                new TShirt("XL", "Green"),
                new TShirt("XXL", "Red"),
                new TShirt("Small", "White"),
                new TShirt("Medium", "Black"),
                new TShirt("Large", "Red"),
                new TShirt("XL", "Blue"),
                new TShirt("XXL", "Green")
        };

        // Print original array
        System.out.println("Original TShirt list:");
        printArray(shirts);

        // Sort by size (uses Comparable)
        bubbleSort(shirts);
        System.out.println("\nSorted by size (using Comparable):");
        printArray(shirts);

        // Sort by color (uses Comparator)
        bubbleSort(shirts, new ColorComparator());
        System.out.println("\nSorted by color (using Comparator):");
        printArray(shirts);
    }

    // Generic bubble sort using Comparable
    public static <E extends Comparable<E>> void bubbleSort(E[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            for (int j = 0; j < list.length - 1 - i; j++) {
                if (list[j].compareTo(list[j + 1]) > 0) {
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
    }

    // Generic bubble sort using Comparator
    public static <E> void bubbleSort(E[] list, Comparator<? super E> comparator) {
        for (int i = 0; i < list.length - 1; i++) {
            for (int j = 0; j < list.length - 1 - i; j++) {
                if (comparator.compare(list[j], list[j + 1]) > 0) {
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
    }

    // Print array method
    public static void printArray(Object[] array) {
        for (Object obj : array) {
            System.out.println(obj);
        }
    }

    // TShirt class with size and color
    static class TShirt implements Comparable<TShirt> {
        String size; // Small, Medium, Large
        String color;

        public TShirt(String size, String color) {
            this.size = size;
            this.color = color;
        }

        // Order: Small < Medium < Large
        @Override
        public int compareTo(TShirt other) {
            return sizeToNumber(this.size) - sizeToNumber(other.size);
        }

        private int sizeToNumber(String size) {
            return switch (size) {
                case "Small" -> 1;
                case "Medium" -> 2;
                case "Large" -> 3;
                case "XL" -> 4;
                case "XXL" -> 5;
                default -> 0;
            };
        }


        @Override
        public String toString() {
            return "TShirt{size='" + size + "', color='" + color + "'}";
        }
    }

    // Comparator to sort TShirts by color alphabetically
    static class ColorComparator implements Comparator<TShirt> {
        @Override
        public int compare(TShirt t1, TShirt t2) {
            return t1.color.compareToIgnoreCase(t2.color);
        }
    }
}
