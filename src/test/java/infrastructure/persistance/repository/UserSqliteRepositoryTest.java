package infrastructure.persistance.repository;

import domain.user.User;
import infrastructure.persistance.dao.UserDao;
import infrastructure.persistance.dto.UserDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class UserSqliteRepositoryTest {

	private UserSqliteRepository userSqliteRepository;

	@Mock
	private UserDao userDao;
	@Mock
	private UserAssembler userAssembler;
	private User user;
	private UserDto userDto;


	@Before
	public void setUp(){
		user = new User();
		userSqliteRepository = new UserSqliteRepository(userDao,userAssembler);
	}

	@Test
	public void whenSavingANewUser_thenTheAssemblerSerializeItToADatabaseFormat()throws Exception{
		userSqliteRepository.save(user);

		verify(userAssembler).assemble(user);
	}

	@Test
	public void whenSavingANewUser_thenDelegateSavingToTheDao()throws Exception{
		userSqliteRepository.save(user);

		verify(userDao).save(userDto);
	}
}
