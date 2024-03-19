package db.dao;

import db.entity.base.BaseDbEntity;
import db.util.JDBCConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public abstract class BaseDAO<T extends BaseDbEntity> implements BaseCRUD<T> {
    protected abstract String getInsertQuery(T insertEntity, Integer id);
    protected abstract String getUpdateQuery(T updateEntity);
    protected abstract String getDeleteQuery(T deleteEntity);
    protected abstract String getNextIdQuery();
    protected abstract String getListQuery();
    protected abstract List<T> findByQuery(String ListQuery);

    @Override
    public boolean insert(T insertEntity) {
        final String insert = getInsertQuery(insertEntity, getNextId(getNextIdQuery()));
        return execute(insert);
    }

    @Override
    public boolean update(T updateEntity) {
        final String delete = getUpdateQuery(updateEntity);
        return execute(delete);
    }

    @Override
    public boolean delete(T deleteEntity) {
        final String update = getDeleteQuery(deleteEntity);
        return execute(update);
    }

    @Override
    public List<T> getListAll() {
        final String getListAll = getListQuery();
        return findByQuery(getListAll);
    }

    public boolean execute(String query){
        try(Connection con = JDBCConnector.getConnection()) {
            try (Statement statement = con.createStatement()){
                statement.execute(query);
            }
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    public Integer getNextId(String nextIdQuery){
        try (Connection con = JDBCConnector.getConnection()){
            try (Statement statement = con.createStatement()){
                statement.execute(nextIdQuery);
                ResultSet resultSet = statement.getResultSet();
                while (resultSet.next()){
                    return resultSet.getInt(1);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return -1;
        }
        return -1;
    }

    



}
