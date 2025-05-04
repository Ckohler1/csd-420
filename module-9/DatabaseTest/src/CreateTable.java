/*
 * Colton Kohler
 * 05/04/2025
 * M9: Programming Assignment
 *
 * Purpose: This program connects to a MySQL database and creates the address33 table.
 */

import java.sql.*;

public class CreateTable {
    Connection databaseConnection;
    Statement sqlStatement;

    public CreateTable() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String databaseUrl = "jdbc:mysql://localhost:3306/databasedb?";
            databaseConnection = DriverManager.getConnection(databaseUrl + "user=student1&password=pass");
            sqlStatement = databaseConnection.createStatement();
        } catch (Exception connectionError) {
            System.out.println("Error connecting to the database.");
            System.exit(0);
        }

        try {
            sqlStatement.executeUpdate("DROP TABLE address33");
            System.out.println("Table address33 dropped.");
        } catch (SQLException e) {
            System.out.println("Table address33 does not exist.");
        }

        try {
            sqlStatement.executeUpdate("CREATE TABLE address33(ID int PRIMARY KEY, LASTNAME varchar(40), " +
                    "FIRSTNAME varchar(40), STREET varchar(40), CITY varchar(40), STATE varchar(40), ZIP varchar(40))");
            System.out.println("Table address33 created.");
        } catch (SQLException e) {
            System.out.println("Table creation failed.");
        }

        try {
            sqlStatement.close();
            databaseConnection.close();
            System.out.println("Database connection closed.");
        } catch (SQLException e) {
            System.out.println("Error closing connection.");
        }
    }

    public static void main(String[] args) {
        CreateTable createTableProgram = new CreateTable();
    }
}
