package ch.bfh.ti.se2012.red.db;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;


public class SqlLogin implements IntSqlLogin {

    private Statement stmt;
    private ResultSet rs;
    private SQLLocalConnection conection;
    private String result;
    private String result2;
	private Connection conn;

    public SqlLogin() {
        conection = SQLLocalConnection.getInstance(); 
        conection.connect();
        stmt = conection.getstatement();
        rs = conection.getresultset();
    }
 

    public String getpassword(String username) {
        try {
            String query = "SELECT UPassword FROM db_red.dbo.Login WHERE Username='"
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
        if (result!=null){
        	return result;	
        }
        else 
        	return "false"; 
        
        
    }

    public boolean validateLogin(String username, String password) {
        if (getpassword(username).equals(password)) {
            return true;
        } else
            return false;

    }
    
    public String setpassword(String username, String newpassword) {
        try {	
        	
        	String query = "SELECT * FROM db_red.dbo.Login WHERE Username='"
                     + username + "'";
            rs = stmt.executeQuery(query);
            	
            if(rs.next()){
            rs.updateString("UPassword", newpassword); 
            rs.updateRow();
            
            }
            result2 = rs.getString(4);
            rs.close();
            

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (result2!=null){
        	return result2;	
        }
        else 
        	return "false"; 
        
        
    }

}

