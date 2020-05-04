package uvsq21807569.exo4_1;

public abstract class AbstractDaoFactory {
public enum DAOType {JDBC, Serialiser};

	

	public abstract DAO<Personnel> getPersonnelDAO();

	

	public abstract DAO<Groupe_Personnel> getPersonnelGroupeDAO();

	

	public static AbstractDaoFactory getFactory(DAOType type) {

		if (type == DAOType.JDBC) return new JdbcDaoFactory();

		if (type == DAOType.Serialiser) return new DAOFactory();

		return null;

	}

}
