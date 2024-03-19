package db.dao;

import db.entity.base.BaseDbEntity;

import java.util.List;

public interface BaseCRUD<T extends BaseDbEntity> {

    boolean insert(T insertEntity);
    boolean update(T updateEntity);
    boolean delete(T deleteEntity);
    List<T> getListAll(String listQuery);


    List<T> getListAll();
}
