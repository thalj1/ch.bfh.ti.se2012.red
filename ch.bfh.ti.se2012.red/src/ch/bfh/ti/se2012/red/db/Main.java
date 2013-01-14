package ch.bfh.ti.se2012.red.db;

import java.sql.SQLException;

public class Main {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		
		SqlLogin login = new SqlLogin();
		System.out.println(login.validateLogin("bpascal", "123456"));
		System.out.println(login.setpassword("bpascal", "12344")); 
		System.out.println(login.validateLogin("bpascal", "123456"));
		System.out.println(login.validateLogin("bpascal", "1234"));
		System.out.println(login.validateLogin("", ""));
	}
}
