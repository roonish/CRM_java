package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connectivity {
    private static Connection connection;

    public static Connection getConnection() {
        String dbName = "CRMDb";
        String userName = "root";
        String password = "";

        try {
            if (connection == null || connection.isClosed()) {
                Class.forName("com.mysql.cj.jdbc.Driver"); 
                connection = DriverManager.getConnection("jdbc:mysql://localhost/" + dbName, userName, password);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }
}
