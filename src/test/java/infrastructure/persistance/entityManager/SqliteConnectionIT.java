package infrastructure.persistance.entityManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import server.ApplicationConfiguration;

import static junit.framework.TestCase.assertTrue;

public class SqliteConnectionIT {

	private SqliteConnection sqliteConnection;

	@Before
	public void setUp(){
		sqliteConnection = new SqliteConnection(ApplicationConfiguration.testSqliteDbName);
	}

	@Ignore
	@Test
	public void whenCreatingConnection_thenConnectionIsOpen()throws Exception{

		boolean isOpen = sqliteConnection.getConnection().isClosed();

		assertTrue(isOpen);
	}

	@After
	public void tearDown(){

	}
}
