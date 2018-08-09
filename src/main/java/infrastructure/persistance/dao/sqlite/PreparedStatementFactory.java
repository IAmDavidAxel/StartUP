package infrastructure.persistance.dao.sqlite;

import infrastructure.persistance.entityManager.SqliteConnection;

import java.sql.SQLException;
import java.util.ArrayList;

public class PreparedStatementFactory {
	private SqliteConnection connection;

	public PreparedStatementFactory(SqliteConnection connection) {
		this.connection = connection;
	}

	public PreparedStatementSqlite createStatement(String query, ArrayList<Object> arguments, Action action) throws SQLException {

		if(action==Action.SELECT){

			ResultSetSqliteAssembler resultSetSqliteAssembler = new ResultSetSqliteAssembler();
			return new PreparedStatementFetch(connection,query,arguments,resultSetSqliteAssembler);
		}else{
			return new PreparedStatementUpdate(connection,query,arguments);
		}

	}
}
