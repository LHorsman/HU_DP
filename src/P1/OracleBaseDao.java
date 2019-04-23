package P1;

import java.sql.*;

abstract public class OracleBaseDao {
    private String connectionString = "jdbc:oracle:thin:@//127.0.0.1:1521/xepdb1";
    private String username = "LUUKWAC";
    private String password = "123456";

    protected Connection getConnection() {
        try {
            return DriverManager.getConnection(this.connectionString, this.username, this.password);
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
