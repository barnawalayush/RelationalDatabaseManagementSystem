package org.example.task3_4;

import java.sql.*;

public class Thread7{

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/relationaldatabase?user=postgres";
    private static final String USER_NAME = "root";
    private static final String USER_PASSWORD = "password";

    public static void main(String[] args) {

        Connection connection = null;
        try{
            connection = DriverManager.getConnection(DB_URL, USER_NAME, USER_PASSWORD);
            try(Statement statement = connection.createStatement()) {

//                final String analyze = "explain analyze SELECT user_id FROM \"user\" where user_id = '2';";
//                ResultSet resultSet = statement.executeQuery(analyze);
//                while (resultSet.next()) {
//                    String executionPlan = resultSet.getString(1);
//                    System.out.println(executionPlan);
//                }

//                Index Only Scan using user_pkey on "user"  (cost=0.42..4.44 rows=1 width=5) (actual time=0.072..0.074 rows=1 loops=1)
//                Index Cond: (user_id = '2'::text)
//                Heap Fetches: 0
//                Planning Time: 0.413 ms
//                Execution Time: 0.109 ms



//                final String analyze = "explain analyze SELECT user_id, user_name FROM \"user\" where user_id = '2';";
//                ResultSet resultSet = statement.executeQuery(analyze);
//                while (resultSet.next()) {
//                    String executionPlan = resultSet.getString(1);
//                    System.out.println(executionPlan);
//                }

//                Index Scan using user_pkey on "user"  (cost=0.42..8.44 rows=1 width=11) (actual time=0.046..0.047 rows=1 loops=1)
//                Index Cond: ((user_id)::text = '2'::text)
//                Planning Time: 0.458 ms
//                Execution Time: 0.082 ms




//                final String analyze = "explain analyze SELECT user_id, user_name FROM \"user\" where user_id = '2';";
//                ResultSet resultSet = statement.executeQuery(analyze);
//                while (resultSet.next()) {
//                    String executionPlan = resultSet.getString(1);
//                    System.out.println(executionPlan);
//                }

//                Index Scan using user_pkey on "user"  (cost=0.42..8.44 rows=1 width=11) (actual time=0.045..0.046 rows=1 loops=1)
//                Index Cond: ((user_id)::text = '2'::text)
//                Planning Time: 0.713 ms
//                Execution Time: 0.081 ms



//                final String analyze = "explain analyze SELECT user_name FROM \"user\" where user_name = 'X100';";
//                ResultSet resultSet = statement.executeQuery(analyze);
//                while (resultSet.next()) {
//                    String executionPlan = resultSet.getString(1);
//                    System.out.println(executionPlan);
//                }

//                Index Only Scan using user_name_idx on "user"  (cost=0.29..4.31 rows=1 width=6) (actual time=0.056..0.057 rows=1 loops=1)
//                Index Cond: (user_name = 'X100'::text)
//                Heap Fetches: 0
//                Planning Time: 0.459 ms
//                Execution Time: 0.098 ms




//                final String analyze = "explain analyze SELECT user_name FROM \"user\" where user_id < '10';";
//                ResultSet resultSet = statement.executeQuery(analyze);
//                while (resultSet.next()) {
//                    String executionPlan = resultSet.getString(1);
//                    System.out.println(executionPlan);
//                }

//                Bitmap Heap Scan on "user"  (cost=28.15..772.01 rows=998 width=6) (actual time=0.012..0.013 rows=2 loops=1)
//                Recheck Cond: ((user_id)::text < '10'::text)
//                Heap Blocks: exact=1
//  ->  Bitmap Index Scan on user_pkey  (cost=0.00..27.90 rows=998 width=0) (actual time=0.005..0.005 rows=2 loops=1)
//                Index Cond: ((user_id)::text < '10'::text)
//                Planning Time: 0.495 ms
//                Execution Time: 0.053 ms


//                final String analyze = "explain analyze SELECT user_password FROM \"user\" where user_id < '100' AND user_name = 'X10';";
//                ResultSet resultSet = statement.executeQuery(analyze);
//                while (resultSet.next()) {
//                    String executionPlan = resultSet.getString(1);
//                    System.out.println(executionPlan);
//                }

//                Index Scan using user_name_idx on "user"  (cost=0.29..8.31 rows=1 width=2) (actual time=0.016..0.017 rows=1 loops=1)
//                Index Cond: ((user_name)::text = 'X10'::text)
//                Filter: ((user_id)::text < '100'::text)
//                Planning Time: 0.590 ms
//                Execution Time: 0.049 ms




//                final String analyze = "explain analyze SELECT user_password FROM \"user\" where user_id < '100' AND user_name = 'X10';";
//                ResultSet resultSet = statement.executeQuery(analyze);
//                while (resultSet.next()) {
//                    String executionPlan = resultSet.getString(1);
//                    System.out.println(executionPlan);
//                }

//                Bitmap Heap Scan on "user"  (cost=27.91..774.28 rows=1 width=2) (actual time=0.012..0.013 rows=1 loops=1)
//                Recheck Cond: ((user_id)::text < '100'::text)
//                Filter: ((user_name)::text = 'X10'::text)
//                Rows Removed by Filter: 2
//                Heap Blocks: exact=1
//  ->  Bitmap Index Scan on user_pkey  (cost=0.00..27.91 rows=999 width=0) (actual time=0.004..0.005 rows=3 loops=1)
//                Index Cond: ((user_id)::text < '100'::text)
//                Planning Time: 0.474 ms
//                Execution Time: 0.054 ms



//                After creation of compound Indexes

//                final String analyze = "explain analyze SELECT user_password FROM \"user\" where user_id < '100' AND user_name = 'X10';";
//                ResultSet resultSet = statement.executeQuery(analyze);
//                while (resultSet.next()) {
//                    String executionPlan = resultSet.getString(1);
//                    System.out.println(executionPlan);
//                }

//                Index Scan using user_idx on "user"  (cost=0.42..8.44 rows=1 width=2) (actual time=0.060..0.061 rows=1 loops=1)
//                Index Cond: (((user_name)::text = 'X10'::text) AND ((user_id)::text < '100'::text))
//                Planning Time: 0.565 ms
//                Execution Time: 0.093 ms


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
