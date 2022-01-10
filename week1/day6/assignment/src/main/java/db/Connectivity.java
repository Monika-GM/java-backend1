package db;


import java.sql.*;
import java.util.Properties;
import java.util.logging.Logger;

public class Connectivity {
    private final Connection connection;

    public Connectivity() throws SQLException {

        new Driver() {
            @Override
            public Connection connect(String url, Properties info) throws SQLException {
                return null;
            }

            @Override
            public boolean acceptsURL(String url) throws SQLException {
                return false;
            }

            @Override
            public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
                return new DriverPropertyInfo[0];
            }

            @Override
            public int getMajorVersion() {
                return 0;
            }

            @Override
            public int getMinorVersion() {
                return 0;
            }

            @Override
            public boolean jdbcCompliant() {
                return false;
            }

            @Override
            public Logger getParentLogger() throws SQLFeatureNotSupportedException {
                return null;
            }
        }; // initialize the mysql driver

        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/week1_case_study_db",
                "root",
                "password"
        ); // trying to make a connectivity

        connection.setAutoCommit(false); // enabling txn management
        System.out.println("---- Connected to MySQL Successfully ----");
    }

    public Connection getConnection() {
        return connection;
    }


}
