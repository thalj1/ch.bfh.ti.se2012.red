package ch.bfh.ti.se2012.red.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public interface IntSqlConnection {

	public void connect();

	public Connection getconnection();

	public Statement getstatement();

	public ResultSet getresultset();

	public void disconnect();

}
