package Book.lk;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBconnection {
	public static void main(String[] args) {

		try {
			//driver
			Class.forName("com.mysql.jdbc.Driver");
			// connection String
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Book", "root", "root");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from login");
			while (rs.next())
				System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}
	

	Connection dbConnection() {
		// TODO Auto-generated method stub
		return null ;
	}

	
	
}
