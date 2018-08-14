package api.user;

import application.user.AccountantService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class UserProfileJsonResourceTest {

	private AccountantJsonResource accountantJsonResource;
	@Mock
	private AccountantService accountantService;
	private AccountantDto accountantDto;

	@Before
	public void setUp(){
		accountantJsonResource = new AccountantJsonResource(accountantService);
	}

	@Test
	public void whenCreatingANewService_thenDeleagateCreationToTheService()throws Exception{

		accountantJsonResource.create(accountantDto);

		verify(accountantService).create(accountantDto);
	}
}
