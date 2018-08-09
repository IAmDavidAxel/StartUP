package infrastructure.persistance.dao.sqlite;

import infrastructure.persistance.entityManager.SqliteConnection;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PreparedStatementFetch extends PreparedStatementSqlite {

	private ResultSetSqliteAssembler resultSetSqliteAssembler;

	public PreparedStatementFetch(SqliteConnection connection, String query, ArrayList<Object> arguments, ResultSetSqliteAssembler resultSetSqliteAssembler) {
		super(connection, query, arguments);
		this.resultSetSqliteAssembler = resultSetSqliteAssembler;
	}

	@Override
	public List<Map<String, Object>> execute() throws SQLException {
		return null;
	}
}
