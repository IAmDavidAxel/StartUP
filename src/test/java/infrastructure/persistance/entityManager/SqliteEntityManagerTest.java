package infrastructure.persistance.entityManager;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.BDDMockito.willThrow;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyBoolean;

@RunWith(MockitoJUnitRunner.class)
public class SqliteEntityManagerTest {

	private SqliteEntityManager entityManager;

	@Mock
	private SqliteConnection connection;

	@Before
	public void setUp(){
		entityManager = new SqliteEntityManager(connection);

	}

	@Test(expected = EntityManagerException.class)
	public void whenBeginningATransactionAndAutoCommitIsNotSetToFalse_thenThrowException()throws Exception{

		willThrow(SqliteConnectionException.class).given(connection).setAutoCommitTo(false);

		entityManager.beginTransaction();
	}
}
