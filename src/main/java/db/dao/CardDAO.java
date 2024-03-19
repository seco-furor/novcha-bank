package db.dao;

import db.entity.CardEntity;

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
                insertEntity.getAccount_id()
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
        return findByQuery(listQuery);
    }


    @Override
    public List<CardEntity> getListAll(String listQuery) {
        return null;
    }
}
