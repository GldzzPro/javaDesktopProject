package tn.uvt.training.bookreservation;

import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Service
public class UserService {

    Connection connection = null;

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/bookreservation";  // Replace with your database

    public boolean connectToDatabase(String username, String password) {
        try {
            connection = DriverManager.getConnection(JDBC_URL, username, password);
            System.out.println("Connected to MySQL database!");
            // You can now perform database operations here
            return true;
        } catch (SQLException e) {
            System.err.println("Failed to connect to MySQL database: " + e.getMessage());
            return false;
        }
    }
}
