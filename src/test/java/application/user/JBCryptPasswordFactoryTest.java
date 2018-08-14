package application.user;

import domain.user.password.JBCryptPasswordFactory;
import domain.user.password.Password;
import domain.user.password.PasswordPolicy;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.willReturn;

@RunWith(MockitoJUnitRunner.class)
public class JBCryptPasswordFactoryTest {

	private static final String PLAIN_PASSWORD = "Wint3rIsC0ming!!";
	private JBCryptPasswordFactory jbCryptPasswordFactory;

	@Mock
	private PasswordPolicy passwordPolicy;

	@Before
	public void setUp(){
		jbCryptPasswordFactory = new JBCryptPasswordFactory(passwordPolicy);
	}

	@Test
	public void whenCreatingANewPassword_thenReturnANewPasswordObject()throws Exception{

		willReturn(true).given(passwordPolicy).isValid(PLAIN_PASSWORD);

		Password password = jbCryptPasswordFactory.create(PLAIN_PASSWORD);

		assertNotNull(password);
	}

	@Test(expected = IllegalPasswordFormatException.class)
	public void whenCreatingANewPassword_thenThrowExceptionDueToNonValidPassword()throws Exception{

		willReturn(false).given(passwordPolicy).isValid(PLAIN_PASSWORD);

		jbCryptPasswordFactory.create(PLAIN_PASSWORD);

	}

}