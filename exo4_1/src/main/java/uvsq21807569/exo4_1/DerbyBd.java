package uvsq21807569.exo4_1;

import java.util.Properties;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DerbyBd {
	private static final String userName = "";
	private static final String password = "";

	public static String url = "jdbc:derby:bd;create=true";

	

	public DerbyBd() {

		Properties connectionProps = new Properties(); 
		connectionProps.put("user", userName);
		connectionProps.put("user", password);
	}
	
	public void createTables() {

		try (Connection connect = DriverManager.getConnection(url)) {
			Statement statement = connect.createStatement();
		    DatabaseMetaData data = connect.getMetaData();
		    ResultSet result = data.getTables(null, null, "PERSONNEL", null);
		    if (result.next()){
		    	System.out.println("table deja existante ");
		    	}else {
		    		statement.addBatch(
		    		"CREATE TABLE Personnel("

							+ "nom VARCHAR(100) not null,"
							+ "prenom VARCHAR(100) NOT NULL,"
							+ "fonction VARCHAR(100) NOT NULL,"
							+ "datenaisssance Date NOT NULL,"
							+ "PRIMARY KEY(nom)"
							+ ")");
		    	}
		    ResultSet resultat = data.getTables(null, null, "GROUPE", null);
		    if (result.next()) {
		    	System.out.println("table deja existante");
		    } else {			

			statement.addBatch("CREATE TABLE Groupe ("
					+ "id VARCHAR(100) PRIMARY KEY"
					+ ")");}
		    
		    
		    ResultSet resu = data.getTables(null, null, "POSSEDE", null);
		    if (resu.next()) {
		    	System.out.println("table deja existante ");
		    } else {

			statement.addBatch( 
								"CREATE TABLE Possede("
								+ "id VARCHAR(100),"
								+ "nom VARCHAR(100)"
								+ ")");
					  }

		statement.executeBatch();
		} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
		}
	}
	}
