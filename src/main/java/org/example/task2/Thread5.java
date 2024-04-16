package org.example.task2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Thread5 extends Thread {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/relationaldatabase?user=postgres";
    private static final String USER_NAME = "root";
    private static final String USER_PASSWORD = "password";

    @Override
    public void run() {
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(DB_URL, USER_NAME, USER_PASSWORD);
            connection.setAutoCommit(false);
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            try(Statement statement = connection.createStatement()) {
                final String change = "update \"user\" set user_name = 'UserThread5' where user_id = '2'";
                statement.executeUpdate(change);
                connection.commit();
            }
        } catch (SQLException e) {
            try {
                e.printStackTrace();
                if (connection != null) {
                    System.out.println("Transaction is being rolled back for " + this.getName());
                    connection.rollback();
                    connection.close();
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}