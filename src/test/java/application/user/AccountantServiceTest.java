package application.user;



import api.user.AccountantDto;
import domain.user.UserProfile;
import domain.user.AccountantRepository;
import domain.user.accountant.Accountant;
import domain.user.credential.Credential;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.BDDMockito.willReturn;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AccountantServiceTest {

	private static final String email = "dd@bb.fr";

	private AccountantService accountantService;

	@Mock
	private AccountantFactory accountantFactory;
	@Mock
	private AccountantRepository accountantRepository;
	private AccountantDto accountantDto;
	private UserProfile userProfile;
	private Accountant accountant;
	private Credential credential;

	@Before
	public void setUp(){
		accountant = new Accountant(userProfile, credential, email);
		accountantDto = new AccountantDto();
		accountantService = new AccountantService(accountantFactory, accountantRepository);
	}

	@Test
	public void whenCreatingANewUser_thenDelegateTransformationToTheAssembler()throws Exception{
		accountantService.create(accountantDto);

		verify(accountantFactory).create(accountantDto);
	}

	@Test
	public void whenCreatingANewUser_thenDelegateSavingToTheRepo()throws Exception{
		willReturn(accountant).given(accountantFactory).create(accountantDto);

		accountantService.create(accountantDto);

		verify(accountantRepository).save(accountant);
	}

}
