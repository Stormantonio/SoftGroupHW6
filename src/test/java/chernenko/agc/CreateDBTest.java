package chernenko.agc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class CreateDBTest {
    public static final String CREATE_DB;
    public static final String COMPLETE_DB;

    static {
        CREATE_DB = readDB("/createDB.sql");
        COMPLETE_DB = readDB("/completeDB.sql");
    }

    private static String readDB(String resourceName) {
        BufferedReader reader = null;
        StringBuilder sb = new StringBuilder();
        try {
            reader = new BufferedReader(new InputStreamReader(ClassLoader.class.getResourceAsStream(resourceName)));
            while (reader.ready()) {
                sb.append(reader.readLine());
                sb.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }

    public static void newTable(String sqlDriver, String url, String username, String password) {
        try {
            Class.forName(sqlDriver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection;
        try {
            connection = DriverManager.getConnection(url, username, password);
            newQuery(connection, CREATE_DB);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void completeTable(String sqlDriver, String url, String username, String password) {
        try {
            Class.forName(sqlDriver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection;
        try {
            connection = DriverManager.getConnection(url, username, password);
            newQuery(connection, COMPLETE_DB);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void newQuery(Connection connection, String sql) {
        try {
            Statement statement = connection.createStatement();
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
