/*
 * Colton Kohler
 * 05/04/2025
 * M9: Programming Assignment
 *
 * Purpose: This program retrieves and prints all rows from the address33 table.
 */

import java.sql.*;

public class Select5 {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String databaseUrl = "jdbc:mysql://localhost:3306/databasedb?";
            Connection databaseConnection = DriverManager.getConnection(databaseUrl + "user=student1&password=pass");

            System.out.println("Connection established - now executing a select query.");

            Statement sqlStatement = databaseConnection.createStatement();
            ResultSet resultSet = sqlStatement.executeQuery("SELECT * FROM address33");

            System.out.println("Received Results:");

            int columnCount = resultSet.getMetaData().getColumnCount();

            while (resultSet.next()) {
                for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                    System.out.println(resultSet.getString(columnIndex));
                }
                System.out.println(""); // Blank line between rows
            }

            sqlStatement.close();
            databaseConnection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
