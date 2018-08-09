package infrastructure.persistance.entityManager;

public class SqliteConnectionException extends Exception {

	public SqliteConnectionException(){
		super("An internal persistence connection error occurred");
	}
}
