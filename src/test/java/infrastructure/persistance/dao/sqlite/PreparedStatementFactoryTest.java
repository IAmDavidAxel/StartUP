package infrastructure.persistance.dao.sqlite;

import infrastructure.persistance.entityManager.SqliteConnection;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

import static junit.framework.TestCase.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class PreparedStatementFactoryTest {

	private static final String QUERY = "select";
	private ArrayList<Object> arguments;

	private PreparedStatementFactory preparedStatementFactory;

	@Mock
	private SqliteConnection connection;


	@Before
	public void setUp(){
		arguments = new ArrayList<>();
		preparedStatementFactory = new PreparedStatementFactory(connection);

	}

	@Ignore
	@Test
	public void whenCreatingAFetchStatement_thenReturnPreparedStatementFetch()throws Exception{

		PreparedStatementSqlite preparedStatementSqlite = preparedStatementFactory.createStatement(QUERY,arguments,Action.SELECT);

		assertTrue(preparedStatementSqlite instanceof PreparedStatementFetch);
	}


	@Ignore
	@Test
	public void whenCreatingAnUpdateStatement_thenReturnPreparedStatementUpdate()throws Exception{

		PreparedStatementSqlite preparedStatementSqlite = preparedStatementFactory.createStatement(QUERY,arguments,Action.UPDATE);

		assertTrue(preparedStatementSqlite instanceof PreparedStatementUpdate);

	}
}
