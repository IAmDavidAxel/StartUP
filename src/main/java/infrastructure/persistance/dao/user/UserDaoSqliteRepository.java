package infrastructure.persistance.dao.user;

import infrastructure.persistance.dao.UserDao;
import infrastructure.persistance.dao.sqlite.DaoInternalException;
import infrastructure.persistance.dao.sqlite.SqliteBuilder;
import infrastructure.persistance.dto.UserDto;
import infrastructure.persistance.entityManager.SqliteConnection;

public class UserDaoSqliteRepository implements UserDao {

	private SqliteConnection sqliteConnection;

	public UserDaoSqliteRepository(SqliteConnection sqliteConnection){

		this.sqliteConnection = sqliteConnection;
	}


	@Override
	public void save(UserDto userDto) throws DaoInternalException {

		SqliteBuilder sqliteBuilder = new SqliteBuilder(sqliteConnection);

		sqliteBuilder.ReplaceInto("user")
				.Columns("")
				.Values(userDto)
				.Execute();
	}
}
