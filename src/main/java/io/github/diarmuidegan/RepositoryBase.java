package io.github.diarmuidegan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class RepositoryBase implements AutoCloseable {
    final Connection connection;
    final QueryRunner runner = new QueryRunner();

    public RepositoryBase(String connectionString, String username, String password) throws SQLException {
        connection = DriverManager.getConnection(connectionString, username, password);
    }

    public RepositoryBase(final Connection connection) throws SQLException {
        this.connection = connection;
    }

    /* Methods */
    public void deleteRecord(Record record) throws SQLException {
        runner.update(connection, SqlStatements.Delete, record.getId());
    }

    public List<Record> getRecords() throws SQLException {
        return runner.query(connection,
                SqlStatements.GetAll,
                new BeanListHandler<Record>(Record.class));
    }

    public Record getRecordById(int recordId) throws SQLException {
        return runner.query(connection,
                SqlStatements.GetById,
                new BeanHandler<Record>(Record.class),
                recordId + "");
    }
    public Record insertRecord(Record record) throws SQLException {
        var beanHandler = new BeanHandler<Record>(Record.class);
        return runner.query(connection, SqlStatements.Insert, beanHandler,
                record.getId() // Don't use Id if auto-increment is on database table column
                // Values to match Columns in SqlStatements.Insert
        );
    }

    /**
     * Update a record in the database
     * @param record The record to update
     * @throws SQLException if a database error occurs
     */
    public void updateRecord(Record record) throws SQLException {
        runner.update(connection, SqlStatements.Update,
                // Values to match Columns in SqlStatements.Update
                record.getId()
        );
    }

    /**
     * Closes the database connection
     * @throws SQLException if a database error occurs
     */
    @Override
    public void close() throws SQLException {
        DbUtils.close(connection);
    }
}
