package db.util;

import db.constants.DBConstants;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseUtil {

    public static boolean createTables() {
        boolean b;

//      create account
        {
            b = createAccountTable();
        }
//      another table
        {
            if (b) {
                b = createCardTable();
            }
        }
        return b;
    }

    private static boolean createAccountTable() {
        try(Connection con = JDBCConnector.getConnection()) {
            try(Statement statement = con.createStatement()) {
                statement.execute(
                        DBConstants._CREATE_ACCOUNT_TABLE
                );
                return true;
        } catch (SQLException e) {
            return false;
        }
    } catch (SQLException e) {
            return false;
        }
    }

    private static boolean createCardTable() {
        try(Connection con = JDBCConnector.getConnection()) {
            try(Statement statement = con.createStatement()) {
                statement.execute(
                        DBConstants._CREATE_CARD_TABLE
                );
                return true;
            } catch (SQLException e) {
                return false;
            }
        } catch (SQLException e) {
            return false;
        }

    }




}
