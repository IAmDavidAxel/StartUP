package infrastructure.persistance.dao.sqlite;

import infrastructure.persistance.entityManager.SqliteConnection;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PreparedStatementUpdate extends PreparedStatementSqlite{

	public PreparedStatementUpdate(SqliteConnection connection, String query, ArrayList<Object> arguments){
		super(connection,query,arguments);
	}

	@Override
	public List<Map<String, Object>> execute() throws SQLException {
		preparedStatement.executeUpdate();

		closeStatement();
		return null;
	}
}
