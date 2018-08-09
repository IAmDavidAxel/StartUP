package infrastructure.persistance.entityManager;


import java.util.logging.Level;
import java.util.logging.Logger;

public class SqliteEntityManager {
	private SqliteConnection connection;

	public SqliteEntityManager(SqliteConnection connection) {
		this.connection = connection;
	}

	public void beginTransaction() throws EntityManagerException {
		try{
			connection.setAutoCommitTo(false);
		}catch (SqliteConnectionException e){
			Logger.getGlobal().log(Level.WARNING,e.getMessage());
			throw new EntityManagerException();
		}
	}

	public void endTransaction()throws EntityManagerException{
		try{
			connection.commit();
		}catch (SqliteConnectionException e){
			Logger.getGlobal().log(Level.WARNING,e.getMessage());
			throw  new EntityManagerException();
		}finally {
			setAutoCommitOn();
		}
	}

	public void rollBack(){
		try{
			connection.rollBack();
		}catch (SqliteConnectionException e){
			Logger.getGlobal().log(Level.WARNING,e.getMessage());
		}finally {
			setAutoCommitOn();
		}
	}

	private void setAutoCommitOn() {
		try{
			connection.setAutoCommitTo(true);
		}catch (SqliteConnectionException e){
			Logger.getGlobal().log(Level.WARNING,e.getMessage());
		}

	}

}
