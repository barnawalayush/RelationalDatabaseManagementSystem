package org.example.task2;

import java.sql.*;

public class Thread6 extends Thread{

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/relationaldatabase?user=postgres";
    private static final String USER_NAME = "root";
    private static final String USER_PASSWORD = "password";

    @Override
    public void run() {
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(DB_URL, USER_NAME, USER_PASSWORD);
            connection.setAutoCommit(false);
            connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
            try(Statement statement = connection.createStatement()) {
                findById(statement);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ignored) {

                }
                findById(statement);
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

    private void findById(Statement statement) throws SQLException {
        try(ResultSet resultSet = statement.executeQuery("select * from \"user\" where user_id = '2';\n")){
            while(resultSet.next()) {
                System.out.println("id: " + resultSet.getInt(1));
                System.out.println("name: " + resultSet.getString(2));
                System.out.println("password: " + resultSet.getString(3));
            }
        }
    }
}
