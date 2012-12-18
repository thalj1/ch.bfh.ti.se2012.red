package ch.bfh.ti.se2012.red.db;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class SqlLogin implements IntSqlLogin {

    private Statement stmt;
    private ResultSet rs;
    private SqlConnection conection;
    private String result;

    public SqlLogin(){
        conection = new SqlConnection();
        conection.connect();
        stmt = conection.getstatement();
        rs = conection.getresultset();
    }
 

    public String getpassword(String username) {
        try {
            String query = "SELECT UPassword FROM Login WHERE Username='"
                    + username + "'";
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                // Loop through the result set
                result = rs.getString(1);
            }
            // Close the result set, statement and the connection
            rs.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return result;
    }

    public boolean validateLogin(String username, String password) {
        String password1 = getpassword(username);
        if (password1.equals(password)) {
            return true;
        } else
            return false;

    }

}

