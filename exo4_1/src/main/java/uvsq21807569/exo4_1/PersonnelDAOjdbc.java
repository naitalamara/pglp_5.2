package uvsq21807569.exo4_1;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonnelDAOjdbc implements DAO<Personnel> {
	private static String url =DerbyBd.url;

	@Override
	public Personnel create(Personnel obj) {
		try (Connection con = DriverManager.getConnection(url)) {
			PreparedStatement pre = con.prepareStatement("INSERT INTO personnels (nom, prenom, fonction,datenaisssance)" +
		"VALUES (?, ?, ?, ?)");

			pre.setString(1, obj.getNom());
			pre.setString(2, obj.getPrenom());
			pre.setString(3, obj.getFonction());
			pre.setDate(4, Date.valueOf(obj.getDatenaissance()));
			System.out.println("Création " + obj);
			int res = pre.executeUpdate();
			assert res== 1; 
					}catch (SQLException e) {
						e.printStackTrace();
					}
		return obj;
		}

	
	
	@Override
	public Personnel read(String nom) {
		Personnel a = null;
		try (Connection con = DriverManager.getConnection(url)) {
			System.out.println("Recherche " + nom);
			PreparedStatement pre = con.prepareStatement(
					"SELECT * FROM personnels WHERE nom = ?");
			pre.setString(1, nom);
			ResultSet res = pre.executeQuery();
			if(res.next()) {
				a = new Personnel.builder(
						res.getString("nom"),
						res.getString("prenom"),
						res.getString("fonction")).build();
						res.close();

			}else {
			System.out.println("la personne n'existe pas");
			}
			}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public Personnel update(Personnel obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Personnel obj) {
		// TODO Auto-generated method stub
		
	}

}
