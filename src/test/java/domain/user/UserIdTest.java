package domain.user;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserIdTest {

	private UserId userId;

	@Before
	public void setUp(){
		userId = new UserId();
	}

	@Test
	public void givenAnUserId_whenCreated_thenItExist(){
		assertNotNull(userId.getIdValue());
	}

	@Test
	public void whenComparingTwoGenerated_thenTheyAreDifferent(){
		UserId secondId = new UserId();

		assertNotEquals(secondId.getIdValue(),userId.getIdValue());

		System.out.print(secondId.getIdValue());
	}

}