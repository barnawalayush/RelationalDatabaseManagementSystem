package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CompoundIndex {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/relationaldatabase?user=postgres";
    private static final String USER_NAME = "root";
    private static final String USER_PASSWORD = "password";

    public static void main(String[] args) {

        try(Connection connection = DriverManager.getConnection(DB_URL, USER_NAME, USER_PASSWORD)) {
            try(Statement statement = connection.createStatement()) {
                final String create_index = "create index if not exists user_idx on \"user\"(user_name, user_id);";
                statement.executeUpdate(create_index);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
