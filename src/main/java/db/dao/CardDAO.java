package db.dao;

import db.entity.CardEntity;
import db.util.JDBCConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CardDAO extends BaseDAO<CardEntity>{

    private static final String insert = "insert into cards(id, card_number, balance, account_id";

    private static final String sequence = "select nextval('cards_seq')";
    @Override
    protected String getInsertQuery(CardEntity insertEntity, Integer id) {
        return String.format(
                insert,
                id,
                insertEntity.getBalance(),
                insertEntity.getCardNumber(),
                insertEntity.getAccounts_id()
        );
    }

    @Override
    protected String getUpdateQuery(CardEntity updateEntity) {
        return null;
    }

    @Override
    protected String getDeleteQuery(CardEntity deleteEntity) {
        return null;
    }

    @Override
    protected String getNextIdQuery() {
        return sequence;
    }

    @Override
    protected String getListQuery() {
        return "select * from card";
    }

    @Override
    protected List<CardEntity> findByQuery(String listQuery) {
        List<CardEntity> result = new ArrayList<>();

        try (Connection con = JDBCConnector.getConnection()) {
            try (Statement statement = con.createStatement()){
                statement.execute(listQuery);

                ResultSet resultSet = statement.getResultSet();
                while (resultSet.next()){
                    CardEntity cardEntity = new CardEntity();

                    Integer id = resultSet.getInt("id");
                    String cardNumber = resultSet.getString("card_number");
                    Double balance = resultSet.getDouble("balance");
                    Integer accountsId = resultSet.getInt("accounts_id");

                    cardEntity.setId(id);
                    cardEntity.setBalance(balance);
                    cardEntity.setCardNumber(cardNumber);
                    cardEntity.setAccounts_id(accountsId);

                    result.add(cardEntity);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }


    @Override
    public List<CardEntity> getListAll(String listQuery) {
        return null;
    }

    public List<CardEntity> findByAccountId(Integer id) {
        String s = "select * from card where accounts_id = %d";
        return findByQuery(String.format(s, id));
    }
}
