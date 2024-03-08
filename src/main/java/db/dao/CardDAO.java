package db.dao;

import db.entity.CardEntity;

public class CardDAO extends BaseDAO<CardEntity> {
    @Override
    protected String getInsertQuery(CardEntity insertEntity, Integer id) {
        return null;
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
        return null;
    }
}
