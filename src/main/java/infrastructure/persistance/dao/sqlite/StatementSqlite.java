package infrastructure.persistance.dao.sqlite;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface StatementSqlite {

	public abstract List<Map<String,Object>> execute() throws SQLException;
}
