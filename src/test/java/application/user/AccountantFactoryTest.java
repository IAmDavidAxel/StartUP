package application.user;

import api.user.AccountantDto;
import domain.user.UserId;
import domain.user.UserProfileFactory;
import domain.user.accessLevel.AccessLevel;
import domain.user.accountant.Accountant;
import domain.user.credential.CredentialFactory;
import domain.user.identifier.UserIdFactory;
import domain.user.password.Password;
import domain.user.password.PasswordFactory;
import domain.user.token.Token;
import domain.user.token.TokenFactory;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.willReturn;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AccountantFactoryTest {

	private static final String EMAIL = "bob@sponge.fr";
	private static final String FIRST_NAME = "Bob";
	private static final String LAST_NAME = "Leponge";
	private static final String PASSWORD = "PatrickStarBesty";
	private static final String USERNAME = "PattyCooker";
	private static final String PLAIN_PASSWORD = "PattyLoverPatrickBestFriend<3";

	private AccountantFactory accountantFactory;
	private AccountantDto accountantDto;

	@Mock
	private UserProfileFactory userProfileFactory;
	@Mock
	private UserIdFactory userIdFactory;
	private UserId userId;
	@Mock
	private PasswordFactory passwordFactory;
	@Mock
	private TokenFactory tokenFactory;
	@Mock
	private CredentialFactory credentialFactory;
	private Password password;
	private Token token;

	private void setUpDto(){
		accountantDto = new AccountantDto();

		accountantDto.setEmail(EMAIL);
		accountantDto.setFirstName(FIRST_NAME);
		accountantDto.setLastName(LAST_NAME);
		accountantDto.setPassword(PLAIN_PASSWORD);
		accountantDto.setUsername(USERNAME);
	}

	@Before
	public void setUp(){
		DateTime dateTime = new DateTime();
		password = new Password(PLAIN_PASSWORD);
		token = new Token(dateTime);
		setUpDto();
		accountantFactory = new AccountantFactory(userIdFactory,userProfileFactory,passwordFactory,tokenFactory,credentialFactory);
	}



	@Test
	public void whenCreatingANewAccountant_thenReturnOne() throws Exception{
		Accountant  accountantFromFactory = accountantFactory.create(accountantDto);

		assertTrue(accountantFromFactory instanceof Accountant);
	}

	@Test
	public void whenCreatingANewAccountant_thenDelegateCreationOfHisUserIdToTheUserIdFactory()throws Exception{
		accountantFactory.create(accountantDto);

		verify(userIdFactory).create();
	}

	@Test
	public void whenCreatingANewAccountant_thenDelegateCreationOfTheProfileWithTheAttributesToTheUserProfileFactory()throws Exception{
		willReturn(userId).given(userIdFactory).create();

		accountantFactory.create(accountantDto);

		verify(userProfileFactory).create(userId,LAST_NAME,FIRST_NAME,USERNAME);
	}

	@Test
	public void whenCreatingANewAcccountant_thenDelegateCreationOfHisCredentialToTheCredentialFactory()throws Exception{

		accountantFactory.create(accountantDto);

		verify(passwordFactory).create(PLAIN_PASSWORD);
	}

	@Test
	public void whenCreatingANewAccountant_thenDelegateCreationOfTheTokenToTheTokenFactory()throws Exception{

		accountantFactory.create(accountantDto);

		verify(tokenFactory).create();
	}

	@Test
	public void whenCreatingANewAccountant_thenDelegateCreationOfTheCredentialToTheFactory()throws Exception{
		willReturn(password).given(passwordFactory).create(PLAIN_PASSWORD);
		willReturn(token).given(tokenFactory).create();


		accountantFactory.create(accountantDto);

		verify(credentialFactory).create(password,token,AccessLevel.ACCOUNTANT);
	}

}