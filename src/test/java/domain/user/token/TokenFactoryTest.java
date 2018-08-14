package domain.user.token;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TokenFactoryTest {

	private TokenFactory tokenFactory;

	@Before
	public void setUp(){
		tokenFactory = new TokenFactory();
	}

	@Test
	public void whenCreatingANewToken_thenItsAnNotNull(){

		Token token = tokenFactory.create();

		assertNotNull(token);
	}

}