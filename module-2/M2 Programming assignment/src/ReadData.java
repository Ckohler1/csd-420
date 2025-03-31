/*
 * Colton Kohler
 * M2 Programming assignment
 * 3/30/2025
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadData {
    private final static Logger LOGGER = Logger.getLogger(ReadData.class.getName());

    public static void main(String[] args) {
        // Specify the filename
        String filename = "ColtonKohler datafile.dat";

        File file = new File(filename);
        if (!file.exists()) {
            System.out.println("The file " + filename + " does not exist.");
            return;
        }

        // Read and display the file content
        try (Scanner scanner = new Scanner(file)) {
            System.out.println("Reading data from " + filename + ":\n");
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            LOGGER.log(Level.SEVERE, "Error: File not found.", e);
        }
    }
}
