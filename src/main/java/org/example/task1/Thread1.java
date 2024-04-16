package org.example.task1;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Thread1 extends Thread{

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/relationaldatabase?user=postgres";
    private static final String USER_NAME = "root";
    private static final String USER_PASSWORD = "password";

    @Override
    public void run() {

        Connection connection = null;
        try{
            connection = DriverManager.getConnection(DB_URL, USER_NAME, USER_PASSWORD);
            connection.setAutoCommit(false);
            try(Statement statement = connection.createStatement()) {

                final String query = "SELECT * FROM \"user\"";
                statement.execute(query);
                int a = 1/0;
                final String change = "INSERT INTO \"user\"(user_id, user_name, user_password) VALUES('4', 'Jessica', 'jessica');";
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