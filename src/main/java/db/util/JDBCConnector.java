package db.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCConnector {
    private static final String dbUrl = "jdbc:postgresql://localhost:5432/Novcha-Bank";
    private static final String username = "postgres";
    private static final String password = "muhsultaher";

    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(
                    dbUrl,
                    username,
                    password
            );
        } catch (SQLException e) {
            System.out.println("connection failed");
            throw new RuntimeException(e);
        }
    }

    public static Statement getStatement(){
        try (Connection con = getConnection()){
            return con.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
