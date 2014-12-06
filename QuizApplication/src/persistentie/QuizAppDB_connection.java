package persistentie;
//package net.codejava.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class QuizAppDB_connection {
 // Hier gaan we de connectie maken met de DB op C:\apache\...
	public QuizAppDB_connection(){
	//connect with embedded driver
	//jdbc:derby:E:/projects/codejava/webdb;create=true
		try{
			String dbURL = "jdbc:derby:C:/Apache/db-derby-10.11.1.1-bin/bin/QuizAppDB";
		
			Connection conn1 = DriverManager.getConnection(dbURL);
				if ( conn1 != null)
				{
				System.out.println("Verbonden met database QuizApp");
				}
		
			}
	
		catch (SQLException ex) 
			{
        ex.printStackTrace();
    		}
	
	}

}
