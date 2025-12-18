package employee.management.system;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class conn {

    public Connection connection;
    public Statement statement;

    public conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/employeemanagement", // DB name
                    "root",                                           // user
                    "123456789"                                      // password
            );

            statement = connection.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(
                    null,
                    "Database error: " + e.getMessage()
            );
        }
    }

    // quick test:
    public static void main(String[] args) {
        new conn();
        JOptionPane.showMessageDialog(null, "Connection successful!");
    }
}
