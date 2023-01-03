package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionMysql {
public static Connection getConnection(){
    String jdbcURL = "jdbc:mysql://localhost:3306/shopdata";
    String jdbcUser="root";
    String jdbcPass="123456";
    Connection connection = null;
    try {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(jdbcURL, jdbcUser, jdbcPass);
    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("error");
    }
    return connection;
}
}
