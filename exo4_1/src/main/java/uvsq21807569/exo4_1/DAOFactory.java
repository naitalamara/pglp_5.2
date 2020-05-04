package uvsq21807569.exo4_1;

public class DAOFactory extends AbstractDaoFactory{
	
	
	

	@Override
	public DAO<Personnel> getPersonnelDAO() {
		return new PersonnelDAO( ) ;
		
	}

	@Override
	public DAO<Groupe_Personnel> getPersonnelGroupeDAO() {
		return new Groupe_PersonnelDAO( ) ;
	}

}
