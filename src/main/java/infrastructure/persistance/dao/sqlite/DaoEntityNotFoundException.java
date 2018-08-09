package infrastructure.persistance.dao.sqlite;

public class DaoEntityNotFoundException extends Exception {

	public DaoEntityNotFoundException(){
		super("The entity does not exits in the database");
	}
}
