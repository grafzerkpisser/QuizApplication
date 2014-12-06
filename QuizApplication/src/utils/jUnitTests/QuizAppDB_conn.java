package utils.jUnitTests;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import static org.junit.Assert.*;

import org.junit.Test;

public class QuizAppDB_conn {

	@Test
	public void testQuizAppDB_connection() {
		try{
			String dbURL = "jdbc:derby:C:/Apache/db-derby-10.11.1.1-bin/bin:QuizAppDB; create=true";
		//
			Connection conn1 = DriverManager.getConnection(dbURL);
				if ( conn1 != null)
				{
				System.out.println("Verbonden met database QuizApp");
				}
				else  {
					System.out.println("Verbinding met database QuizApp mislukt");
				}
		
			}
	
		catch (SQLException ex) 
			{
        ex.printStackTrace();{
        	System.out.println("Foute URL");
        };
    		}
	}

}
