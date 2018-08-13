package infrastructure.persistance.entityManager;

import org.sqlite.SQLiteConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SqliteConnection {

	private static final String SQLITE_DRIVER = "jdbc:sqlite:";

	private String databaseName;
	private Connection connection;

	public SqliteConnection (String databaseName){
		this.databaseName = databaseName;
		initialiseConnection();
	}

	private void initialiseConnection(){
		SQLiteConfig config = new SQLiteConfig();
		config.enforceForeignKeys(true);
		String connectionUrl = buildUrl();

		try{
			connection = DriverManager.getConnection(connectionUrl,config.toProperties());
		}catch ( SQLException e){
			Logger.getGlobal().log(Level.SEVERE,e.getMessage());
		}
	}

	public void commit() throws SqliteConnectionException{
		try{
			connection.commit();
		}catch (SQLException e){
			Logger.getGlobal().log(Level.SEVERE,e.getMessage());
			throw  new SqliteConnectionException();
		}
	}

	public void setAutoCommitTo(boolean isAutoCommitOn) throws SqliteConnectionException{
		try {
			connection.setAutoCommit(isAutoCommitOn);
		}catch (SQLException e){
			Logger.getGlobal().log(Level.SEVERE,e.getMessage());
			throw  new SqliteConnectionException();
		}
	}

	public void rollBack()throws SqliteConnectionException{
		try{
			connection.rollback();
		}catch (SQLException e){
			Logger.getGlobal().log(Level.SEVERE,e.getMessage());
			throw new SqliteConnectionException();
		}
	}


	public Connection getConnection() {
		return connection;
	}

	private String buildUrl() {
		return SQLITE_DRIVER + databaseName;
	}
}
