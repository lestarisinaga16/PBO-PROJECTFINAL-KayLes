package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String URL = "jdbc:mysql://localhost:3306/databasekeyles";  // Sesuaikan nama database Anda
    private static final String USER = "root";  // Username default di XAMPP adalah root
    private static final String PASSWORD = "";  // Biasanya kosong di XAMPP
    private static Connection connection;

    public static Connection getConnection() {
        return connection;
    }

    public void setup() {
        try {
            // Memastikan driver JDBC yang benar digunakan
            Class.forName("com.mysql.cj.jdbc.Driver");  // Gunakan Driver untuk versi terbaru MySQL
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Database connected!");
        } catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage());
            e.printStackTrace();  // Tampilkan stack trace error untuk debugging
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver tidak ditemukan: " + e.getMessage());
        }
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Database connection closed.");
            } catch (SQLException e) {
                System.err.println("Error closing connection: " + e.getMessage());
            }
        }
    }
}
