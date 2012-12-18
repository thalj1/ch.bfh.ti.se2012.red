package ch.bfh.ti.se2012.red.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;

public class SqlConnection {

    private Connection conn;
    private Statement stmt;
    private ResultSet rs;

    public void connect() {

        try {
            // Load the database driver
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            // Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();

            // Get a connection to the database
            String url = "jdbc:jtds:sqlserver://147.87.98.131:55783";
            Connection conn = DriverManager.getConnection(url, "se2012_red",
                    "Thanuc57ch");

            // Get a statement from the connection
            stmt = conn.createStatement();

            // Print all warnings
            for (SQLWarning warn = conn.getWarnings(); warn != null; warn = warn
                    .getNextWarning()) {
                System.out.println("SQL Warning:");
                System.out.println("State  : " + warn.getSQLState());
                System.out.println("Message: " + warn.getMessage());
                System.out.println("Error  : " + warn.getErrorCode());
            }
        } catch (SQLException se) {
            System.out.println("SQL Exception:");

            // Loop through the SQL Exceptions
            while (se != null) {
                System.out.println("State  : " + se.getSQLState());
                System.out.println("Message: " + se.getMessage());
                System.out.println("Error  : " + se.getErrorCode());

                se = se.getNextException();
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public Connection getconnection(){
        return conn;
    }
    public Statement getstatement(){
        return stmt;
    }
    public ResultSet getresultset(){
        return rs;
    }

    public void disconnect() {
        try {
            // Close the result set, statement and the connection
            conn.close();

        } catch (SQLException se) {
            System.out.println("SQL Exception:");

            // Loop through the SQL Exceptions
            while (se != null) {
                System.out.println("State  : " + se.getSQLState());
                System.out.println("Message: " + se.getMessage());
                System.out.println("Error  : " + se.getErrorCode());

                se = se.getNextException();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

