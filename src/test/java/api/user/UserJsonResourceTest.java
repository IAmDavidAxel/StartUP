package api.user;

import application.user.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class UserJsonResourceTest {

	private UserJsonResource userJsonResource;
	@Mock
	private UserService userService;
	private UserDto userDto;

	@Before
	public void setUp(){
		userJsonResource = new UserJsonResource(userService);
	}

	@Test
	public void whenCreatingANewService_thenDeleagateCreationToTheService()throws Exception{

		userJsonResource.create(userDto);

		verify(userService).create(userDto);
	}
}
