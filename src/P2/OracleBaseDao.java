package P2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

abstract public class OracleBaseDao {
    private String connectionString = "jdbc:oracle:thin:@//127.0.0.1:1521/xepdb1";
    private String username = "LUUKOVCHIP";
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
