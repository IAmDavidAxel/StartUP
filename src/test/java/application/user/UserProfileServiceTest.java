package application.user;



import api.user.AccountantDto;
import domain.user.UserProfile;
import domain.user.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.BDDMockito.willReturn;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class UserProfileServiceTest {

	private UserService userService;

	@Mock
	private UserAssembler userAssembler;
	@Mock
	private UserRepository userRepository;
	private AccountantDto accountantDto;
	private UserProfile userProfile;

	@Before
	public void setUp(){
		accountantDto = new AccountantDto();
		userService = new UserService(userAssembler,userRepository);
	}

	@Test
	public void whenCreatingANewUser_thenDelegateTransformationToTheAssembler()throws Exception{
		userService.create(accountantDto);

		verify(userAssembler).assemble(accountantDto);
	}

	@Test
	public void whenCreatingANewUser_thenDeleagateSavingToTheRepo()throws Exception{
		willReturn(userProfile).given(userAssembler).assemble(accountantDto);

		userService.create(accountantDto);

		verify(userRepository).save(userProfile);

	}

}