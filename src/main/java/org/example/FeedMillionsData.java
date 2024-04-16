package org.example;

import java.sql.*;

public class FeedMillionsData {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/relationaldatabase?user=postgres";
    private static final String USER_NAME = "root";
    private static final String USER_PASSWORD = "password";

    public static void main(String[] args) {

        Connection connection = null;
        try{
            connection = DriverManager.getConnection(DB_URL, USER_NAME, USER_PASSWORD);
            try(PreparedStatement statement = connection.prepareStatement("INSERT INTO \"user\"(user_id, user_name, user_password) VALUES(?,?,?);")) {

                for(int i=0; i<100000; i++){
                    statement.setString(1, String.valueOf(i));
                    statement.setString(2, "X" + i);
                    statement.setString(3, "x");
                    statement.execute();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
