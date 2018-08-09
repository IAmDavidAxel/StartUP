package infrastructure.persistance.dao.sqlite;

public class DaoInternalException extends Exception {

	public DaoInternalException (){
		super("An internal persistence error occurred");
	}
}
