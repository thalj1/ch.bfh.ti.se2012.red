package ch.bfh.ti.se2012.red.db;

public interface IntSqlLogin {

	public String getpassword(String username);

	public boolean validateLogin(String username, String password);

}
