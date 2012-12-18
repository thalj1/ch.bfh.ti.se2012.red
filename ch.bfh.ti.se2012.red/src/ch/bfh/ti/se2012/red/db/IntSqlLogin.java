package ch.bfh.ti.se2012.red.db;

import java.sql.Connection;
import java.sql.Statement;

public interface IntSqlLogin {
	
	public boolean validateLogin(Connection con, Statement stmt, String username, String password); 
}
