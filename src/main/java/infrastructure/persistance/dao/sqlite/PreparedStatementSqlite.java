package infrastructure.persistance.dao.sqlite;

import infrastructure.persistance.entityManager.SqliteConnection;

import javax.security.auth.login.LoginException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class PreparedStatementSqlite implements StatementSqlite {

	protected Connection connection;
	protected PreparedStatement preparedStatement;

	public PreparedStatementSqlite(SqliteConnection connection, String query,
	                               ArrayList<Object> arguments){

		this.connection = connection.getConnection();
		initializeStatement(query);
		setArguments(arguments);

	}

	private void setArguments(ArrayList<Object> arguments){
		try {
			for (int i = 0; i < arguments.size(); i++) {

				preparedStatement.setObject(i+1, arguments.get(i));
			}
		}catch (SQLException e){
			Logger.getGlobal().log(Level.WARNING,e.getMessage());
		}
	}

	private void initializeStatement(String query){
		try{
			preparedStatement = connection.prepareStatement(query);
		}catch (SQLException e){
			Logger.getGlobal().log(Level.WARNING,e.getMessage());
		}
	}

	public void close(ResultSet resultSet) {
		try {
			resultSet.close();
		} catch (SQLException exception) {
			Logger.getGlobal().log(Level.FINEST, exception.getMessage());
		}
	}

	public void closeStatement() {
		try {
			preparedStatement.close();
		} catch (SQLException exception) {
			Logger.getGlobal().log(Level.FINEST, exception.getMessage());
		}
	}


}
