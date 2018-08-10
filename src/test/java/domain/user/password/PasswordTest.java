package domain.user.password;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotEquals;

public class PasswordTest {

	private static final String PLAIN_PASSWORD = "JamesWorthy";


	private Password password;

	@Before
	public void setUp(){
		password = new Password(PLAIN_PASSWORD);
	}

	@Test
	public void whenAPasswordIsCrypted_thenItsDifferentThanThePlainOne()throws Exception{

		String digestedPassword = password.getDigest();

		assertNotEquals(digestedPassword,PLAIN_PASSWORD);

		System.out.println(PLAIN_PASSWORD);
		System.out.println(digestedPassword);
	}

	@Test(expected = MismatchedPasswordException.class)
	public void whenGivenADifferentPassword_thenRaisesException()throws Exception{
		String differentPlainPassword = "BobCousy";

		password.verify(differentPlainPassword);
	}



}
