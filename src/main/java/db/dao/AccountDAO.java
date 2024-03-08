package db.dao;

import db.entity.AccountEntity;

public class AccountDAO extends BaseDAO<AccountEntity> {
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
}
