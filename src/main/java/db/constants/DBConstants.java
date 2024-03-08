package db.constants;

public class DBConstants {
//    create Tables
    public static final String _CREATE_ACCOUNT_TABLE = "create table if not exists ACCOUNTS (\n    ID INT PRIMARY KEY,\n    USER_NAME VARCHAR(400),\n    FIRST_NAME VARCHAR(400),\n    LAST_NAME VARCHAR(400)\n);";
    public static final String _CREATE_CARD_TABLE = "create table if not exists CARD (\n    ID INT PRIMARY KEY,\n    CARD_NUMBER VARCHAR(400),\n    BALANCE FLOAT,\n    ACCOUNTS_ID INT REFERENCES ACCOUNTS(ID)\n);";
}
