package org.learn.tech.juc;

import java.sql.*;

/**
 * User: jimjian
 * Date: 16-6-2 下午6:23
 */
public class test_ThreadLocal {

    public static void main(String[] args) {
        Connection connection = test_ThreadLocal.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from emp");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + "  " + resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static String DB_URL = "jdbc:mysql://localhost:3306/test?autoReconnect=true&amp;amp;useUnicode=true&amp;amp;characterEncoding=UTF-8";
    private static String NAME = "root";
    private static String PASSWORD = "root";
    private static ThreadLocal<Connection> connectionThreadLocal = new ThreadLocal<Connection>() {
        public Connection initialValue() {
            Connection connection = null;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(DB_URL, NAME, PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            return connection;
        }
    };

    public static Connection getConnection() {
        return connectionThreadLocal.get();
    }
}
