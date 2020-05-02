package uvsq21807569.exo4_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class Groupe_PersonnelDaoJdbc implements DAO<Groupe_Personnel> {
	private static String url =DerbyBd.url;
	
	@Override
	public Groupe_Personnel create(Groupe_Personnel obj) {
		try (Connection con = DriverManager.getConnection(url)){
			PreparedStatement pre= con.prepareStatement(
					"INSERT INTO groupe (id)" +"VALUES (?)");
			pre.setString(1, obj.getId());
			int result = pre.executeUpdate();
			assert result == 1;

			List<Personnel> list = obj.retournergroupe();
		for(Personnel pers : list) {
						pre = con.prepareStatement(
							"INSERT INTO POSSEDE "	+ "VALUES (?, ?)");
					pre.setString(1, obj.getId());
					pre.setString(2, pers.getNom());
					pre.addBatch();
					}
					pre.executeBatch();
				}
				catch (SQLException e) {
					e.printStackTrace();
					}
				return obj;
				}


	

			

			
		
	

	@Override
	public Groupe_Personnel read(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Groupe_Personnel update(Groupe_Personnel obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Groupe_Personnel obj) {
		// TODO Auto-generated method stub
		
	}

}
