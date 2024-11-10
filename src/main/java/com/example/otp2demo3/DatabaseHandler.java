package com.example.otp2demo3;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseHandler {

    private Connection connection;

    // Database connection details
    private static final String URL = "jdbc:mariadb://localhost:3306/fuel_consumption";
    private static final String USER = "root";
    private static final String PASSWORD = "H1n1zahra3023381";

    public DatabaseHandler() {
        connect();
    }

    // Establish connection to MariaDB
    private void connect() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Database connected successfully.");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to save fuel consumption data
    public void saveFuelConsumption(double distance, double fuel, double consumption) {
        String query = "INSERT INTO fuel_consumption (distance, fuel, consumption) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setDouble(1, distance);
            statement.setDouble(2, fuel);
            statement.setDouble(3, consumption);
            statement.executeUpdate();
            System.out.println("Data saved successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Close the connection
    public void close() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Database connection closed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
