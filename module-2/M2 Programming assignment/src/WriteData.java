/*
 * Colton Kohler
 * M2 Programming assignment
 * 3/30/2025
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WriteData {
    private final static Logger LOGGER = Logger.getLogger(WriteData.class.getName());

    public static void main(String[] args) {
        // Create arrays for five random integers and five random double values
        int[] randomIntegers = new int[5];
        double[] randomDoubles = new double[5];
        Random rand = new Random();

        // Populate the arrays with random values
        for (int i = 0; i < 5; i++) {
            randomIntegers[i] = rand.nextInt(100);           // Random integer between 0 and 99
            randomDoubles[i] = rand.nextDouble() * 100;        // Random double between 0.0 and 100.0
        }

        // Specify the filename
        String filename = "ColtonKohler datafile.dat";

        // Write data to the file (append mode)
        try (FileWriter fw = new FileWriter(filename, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {

            out.println("Random Integers:");
            for (int num : randomIntegers) {
                out.print(num + " ");
            }
            out.println(); // New line

            out.println("Random Doubles:");
            for (double d : randomDoubles) {
                out.print(d + " ");
            }
            out.println(); // New line

            out.println("----------"); // Separator between entries

            System.out.println("Data has been written to " + filename);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "An error occurred while writing to the file.", e);
        }
    }
}
