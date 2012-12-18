package ch.bfh.ti.se2012.red.db;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SqlConnection con = new SqlConnection();
		con.connect();
		SqlLogin login = new SqlLogin();
		System.out.println(login.validateLogin(con.getconnection(), con.getstatement(), con.getresultset(),"bpascal", "123456"));
		con.disconnect();
	}
}
