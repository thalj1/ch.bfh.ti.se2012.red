package ch.bfh.ti.se2012.red.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlLogin {

	private String ergebnis;

	public String getpassword(Connection con, Statement stmt, ResultSet rs,
			String username) {
		try {
			String query = "SELECT UPassword FROM Login WHERE Username='"
					+ username + "'";
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				// Loop through the result set
				ergebnis = rs.getString(1);
			}
			// Close the result set, statement and the connection
			rs.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ergebnis;
	}

	public boolean validateLogin(Connection con, Statement stmt, ResultSet rs,
			String username, String password) {
		String password1 = getpassword(con, stmt, rs, username);
		if (password1.equals(password)) {
			return true;
		} else
			return false;

	}

}
