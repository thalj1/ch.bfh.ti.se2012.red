package ch.bfh.ti.se2012.red.db;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		SqlLogin login = new SqlLogin();
		System.out.println(login.validateLogin("bpascal", "123456"));
		System.out.println(login.validateLogin("", ""));
	}
}
