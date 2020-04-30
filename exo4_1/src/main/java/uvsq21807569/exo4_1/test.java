package uvsq21807569.exo4_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		final String userName = "";

		final String password = "";
		String dburl = "jdbc:derby:Derby;create=true";
		
		try (Connection connect = DriverManager.getConnection(dburl)) {
			Statement state = connect.createStatement();
			System.out.println();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
