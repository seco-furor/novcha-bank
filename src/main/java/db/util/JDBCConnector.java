package db.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCConnector {
    private static final String dbUrl = "jdbc:postgresql://localhost:5432/novcha-bank";
    private static final String dbUsername = "postgres";
    private static final String dbPassword = "1234";

    public static Connection getConnection() {
        try {
            return DriverManager
                    .getConnection(
                            dbUrl,
                            dbUsername,
                            dbPassword
                    );
        } catch (SQLException e) {
            System.out.println("Birzatlar qata ketti, bazag'a ulana almadi");
            throw new RuntimeException(e);
        }
    }
}
