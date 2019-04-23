package databaseconnection;

import java.sql.*;

public class DatabaseConnection {
    public static void main(String[] args) {
        String connectionString = "jdbc:oracle:thin:@//127.0.0.1:1521/xepdb1";
        String username = "LUUKWAC";
        String password = "123456";

        try {
            Connection conn = DriverManager.getConnection(connectionString, username, password);
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM CURSUSSEN");
            while(result.next()) {
                System.out.println(result.getString("code"));
            }
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
