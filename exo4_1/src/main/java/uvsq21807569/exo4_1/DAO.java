package uvsq21807569.exo4_1;

public interface DAO<T> {

	T create(T obj);

	T read(String id);

	T update(T obj);

	void delete(T obj);
	
}
