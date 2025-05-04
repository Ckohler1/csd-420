/*
 * Colton Kohler
 * 05/04/2025
 * M9: Programming Assignment
 *
 * Purpose: This program inserts multiple records into the address33 table.
 */

import java.sql.*;

public class InsertData {
    Connection databaseConnection;
    Statement sqlStatement;

    public InsertData() {
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
            System.out.println(sqlStatement.executeUpdate(
                    "INSERT INTO address33 VALUES(55,'Larry','Rich','1111 Redwing Circle888','Bellevue','NE','68123')") + " row updated");
            System.out.println(sqlStatement.executeUpdate(
                    "INSERT INTO address33 VALUES(1,'Fine','Ruth','1111 Redwing Circle','Bellevue','NE','68123')") + " row updated");
            System.out.println(sqlStatement.executeUpdate(
                    "INSERT INTO address33 VALUES(2,'Howard','Curly','1000 Galvin Road South','Bellevue','NE','68005')") + " row updated");
            System.out.println(sqlStatement.executeUpdate(
                    "INSERT INTO address33 VALUES(3,'Howard','Will','2919 Redwing Circle','Bellevue','NE','68123')") + " row updated");
            System.out.println(sqlStatement.executeUpdate(
                    "INSERT INTO address33 VALUES(4,'Wilson','Larry','1121 Redwing Circle','Bellevue','NE','68124')") + " row updated");
            System.out.println(sqlStatement.executeUpdate(
                    "INSERT INTO address33 VALUES(5,'Johnson','George','1300 Galvin Road South','Bellevue','NE','68006')") + " row updated");
            System.out.println(sqlStatement.executeUpdate(
                    "INSERT INTO address33 VALUES(6,'Long','Matthew','2419 Redwing Circle','Bellevue','NE','68127')") + " row updated");
            System.out.println(sqlStatement.executeUpdate(
                    "INSERT INTO address33 VALUES(44,'Tom','Matthew','1999 Redwing Circle','Bellevue','NE','68123')") + " row updated");

            sqlStatement.executeUpdate("COMMIT");
            System.out.println("Data inserted.");
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("Insert data failed.");
        }

        try {
            sqlStatement.close();
            databaseConnection.close();
            System.out.println("Database connection closed.");
        } catch (SQLException e) {
            System.out.println("Connection close failed.");
        }
    }

    public static void main(String[] args) {
        InsertData insertDataProgram = new InsertData();
    }
}
