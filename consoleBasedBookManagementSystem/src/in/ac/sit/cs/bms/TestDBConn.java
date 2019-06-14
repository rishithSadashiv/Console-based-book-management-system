package in.ac.sit.cs.bms;

import java.sql.Connection;

import in.ac.sit.cs.bms.DBConnectionManager;

public class TestDBConn {

	public static void main(String[] args) {

Connection conn = DBConnectionManager.getConnection();
		
		if(conn != null)
		{
			System.out.println("Connection Success ");
		}
		else
		{
			System.out.println("Connection fail");
		}
	}

}
