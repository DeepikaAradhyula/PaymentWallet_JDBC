package com.cg.wallet.db;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.cg.wallet.exception.WalletException;

public class DBUtil {
	public static Connection getConnection() throws WalletException{
	//	String url="jdbc:oracle:thin:@localhost:1521:xe";
		String url="jdbc:mysql://localhost:3306/jdbc";
		try{
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName("com.mysql.jdbc.Driver");
			//return DriverManager.getConnection(url,"system","root");
			return DriverManager.getConnection(url,"root","root");
		}catch(ClassNotFoundException e){
			throw new WalletException(e.getMessage());
		}catch(SQLException e1){
			throw new WalletException(e1.getMessage());
		}
		
		
	}
}
