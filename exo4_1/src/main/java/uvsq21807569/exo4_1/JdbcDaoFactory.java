package uvsq21807569.exo4_1;

public class JdbcDaoFactory extends AbstractDaoFactory {

	@Override
	public DAO<Personnel> getPersonnelDAO() {
		return new PersonnelDAOjdbc();
	}

	@Override
	public DAO<Groupe_Personnel> getPersonnelGroupeDAO() {
		return new Groupe_PersonnelDaoJdbc();
	}

}
