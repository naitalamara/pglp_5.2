package uvsq21807569.exo4_1;

public class DAOFactory {
	public static DAO<Personnel> getPersonneDAO() {

		return new PersonnelDAO( ) ;

		}

	public static DAO<Groupe_Personnel> getGroupeDAO() {

		return new Groupe_PersonnelDAO( ) ;

		}

}
