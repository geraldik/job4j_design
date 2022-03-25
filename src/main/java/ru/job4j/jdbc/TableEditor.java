package ru.job4j.jdbc;

import ru.job4j.io.Config;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {

    private Connection connection;

    private Properties properties;

    public TableEditor(Properties properties) {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() {
        try {
            this.connection = getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void executeSQL(String sql) {
        try (var statement = connection.createStatement()) {
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTable(String tableName) {
        var sql = String.format(
                "create table if not exists %s(%s);",
                tableName,
                "id serial primary key"
        );
        executeSQL(sql);
    }

    public void dropTable(String tableName) {
        var sql = String.format(
                "drop table if exists %s;",
                tableName
        );
        executeSQL(sql);
    }

    public void addColumn(String tableName, String columnName, String type) {
        var sql = String.format(
                "alter table %s add column if not exists %s %s;",
                tableName,
                columnName,
                type
        );
        executeSQL(sql);
    }

    public void dropColumn(String tableName, String columnName) {
        var sql = String.format(
                "alter table %s drop column if exists %s;",
                tableName,
                columnName
        );
        executeSQL(sql);
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) {
        var sql = String.format(
                "alter table %s rename column %s to %s;",
                tableName,
                columnName,
                newColumnName
        );
        executeSQL(sql);
    }

    public String getTableScheme(String tableName) throws Exception {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "select * from %s limit 1", tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
        }
        return buffer.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    private Connection getConnection() throws Exception {
        Class.forName(properties.getProperty("hibernate.connection.driver_class"));
        String url = properties.getProperty("hibernate.connection.url");
        String login = properties.getProperty("hibernate.connection.username");
        String password = properties.getProperty("hibernate.connection.password");
        return DriverManager.getConnection(url, login, password);
    }

    public static void main(String[] args) {
        try (FileReader reader = new FileReader("app.properties")) {
            Properties properties = new Properties();
            properties.load(reader);
            try (TableEditor tableEditor = new TableEditor(properties)) {

                tableEditor.createTable("table_name");
                System.out.println(tableEditor.getTableScheme("table_name"));

                tableEditor.addColumn("table_name", "column_name", "varchar(255)");
                System.out.println(tableEditor.getTableScheme("table_name"));

                tableEditor.renameColumn("table_name", "column_name", "new_column_name");
                System.out.println(tableEditor.getTableScheme("table_name"));

                tableEditor.dropColumn("table_name", "new_name");
                System.out.println(tableEditor.getTableScheme("table_name"));

                tableEditor.dropTable("table_name");
                System.out.println(tableEditor.getTableScheme("table_name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}