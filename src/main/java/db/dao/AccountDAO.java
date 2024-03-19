package db.dao;

import db.entity.AccountEntity;
import db.util.JDBCConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO extends BaseDAO<AccountEntity>{
    private static final String insert = "INSERT INTO ACCOUNTS(ID, USER_NAME, LAST_NAME) VALUES(%d, '%s', '%s');";
    private static final String sequence = "SELECT nextval('accounts_seq')";

    @Override
    protected String getInsertQuery(AccountEntity insertEntity, Integer id) {
        return String.format(insert, id, insertEntity.getUser_name(), insertEntity.getLast_name());
    }

    @Override
    protected String getUpdateQuery(AccountEntity updateEntity) {
        return null;
    }

    @Override
    protected String getDeleteQuery(AccountEntity deleteEntity) {
        return null;
    }

    @Override
    protected String getNextIdQuery() {
        return sequence;
    }

    @Override
    protected String getListQuery() {
        return "select * from accounts";
    }

    @Override
    public List<AccountEntity> findByQuery(String listQuery) {
        List<AccountEntity> result = new ArrayList<>();

        try (Connection con = JDBCConnector.getConnection()){
            try (Statement statement = con.createStatement()){
                statement.execute(listQuery);

                ResultSet resultSet = statement.getResultSet();
                while (resultSet.next()){
                    AccountEntity accountEntity = new AccountEntity();

                    Integer id = resultSet.getInt("id");
                    String last = resultSet.getString("last_name");
                    String user = resultSet.getString("user_name");
                    String first = resultSet.getString("first_name");

                    accountEntity.setId(id);
                    accountEntity.setUser_name(user);
                    accountEntity.setLast_name(last);
                    accountEntity.setFirst_name(first);

                    result.add(accountEntity);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public AccountEntity findById(Integer id) {
        final String queryID = "select * from accounts where id = %d";
        List<AccountEntity> byQuery = findByQuery(String.format(queryID, id));

        if(byQuery.size() == 1){
            return byQuery.get(0);
        } else {
            return new AccountEntity();
        }
    }

    @Override
    public List<AccountEntity> getListAll(String listQuery) {
        return null;
    }

    public AccountEntity findByUserName(String next) {
        final String queryByUserName = "select * from accounts where user_name = '%s'";
        List<AccountEntity> byQuery = findByQuery(String.format(queryByUserName, next));
        if (byQuery.size() == 1){
            return byQuery.get(0);
        }

        return null;

    }
}
