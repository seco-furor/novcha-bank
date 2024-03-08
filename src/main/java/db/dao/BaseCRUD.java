package db.dao;

import db.entity.base.BaseDbEntity;

public interface BaseCRUD<T extends BaseDbEntity> {
    boolean insert(T insertEntity);
    boolean update(T updateEntity);
    boolean delete(T deleteEntity);
}
