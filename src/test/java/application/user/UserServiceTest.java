package application.user;



import api.user.UserDto;
import domain.user.User;
import domain.user.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.willReturn;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

	private UserService userService;

	@Mock
	private UserAssembler userAssembler;
	@Mock
	private UserRepository userRepository;
	private UserDto userDto;
	private User user;

	@Before
	public void setUp(){
		userDto = new UserDto();
		userService = new UserService(userAssembler,userRepository);
	}

	@Test
	public void whenCreatingANewUser_thenDelegateTransformationToTheAssembler()throws Exception{
		userService.create(userDto);

		verify(userAssembler).assemble(userDto);
	}

	@Test
	public void whenCreatingANewUser_thenDeleagateSavingToTheRepo()throws Exception{
		willReturn(user).given(userAssembler).assemble(userDto);

		userService.create(userDto);

		verify(userRepository).save(user);

	}

}