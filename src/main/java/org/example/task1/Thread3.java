package org.example.task1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Thread3 extends Thread {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/relationaldatabase?user=postgres";
    private static final String USER_NAME = "root";
    private static final String USER_PASSWORD = "password";

    @Override
    public void run() {
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(DB_URL, USER_NAME, USER_PASSWORD);
            try(Statement statement = connection.createStatement()) {

                final String change = "INSERT INTO \"user\"(user_id, user_name, user_password) VALUES('4', 'Jessica', 'jessica');";
                statement.executeUpdate(change);
                int a = 1/0;
                final String update = """
                        delete from doctor where id = %d
                        """.formatted(3);
                statement.executeUpdate(update);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
