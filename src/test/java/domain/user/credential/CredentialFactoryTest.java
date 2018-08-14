package domain.user.credential;

import domain.user.accessLevel.AccessLevel;
import domain.user.password.Password;
import domain.user.token.Token;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CredentialFactoryTest {

	private CredentialFactory credentialFactory;
	private Password password;
	private Token token;

	@Before
	public void setUp(){
		credentialFactory = new CredentialFactory();
	}

	@Test
	public void whenCreatingANewCredential_thenReturnANewObject()throws Exception{

		Credential credential = credentialFactory.create(password,token,AccessLevel.ACCOUNTANT);

		assertNotNull(credential);

	}

}