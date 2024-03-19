package db.constants;

public class DBConstants {
//  create table
    public static final String _CREATE_ACCOUNT_TABLE = "create table if not exists ACCOUNTS (\n" +
                                                        "id int primary key,\n" +
                                                        "user_name varchar(400),\n" +
                                                        "first_name varchar(400),\n" +
                                                        "last_name varchar(400)\n" +
                                                        ");";

    public static final String _CREATE_CARD_TABLE = "create table if not exists CARD (\n" +
                                                    "id int primary key, \n" +
                                                    "card_number varchar(400), \n" +
                                                    "balance float, \n" +
                                                    "accounts_id int references accounts(id));";
}
