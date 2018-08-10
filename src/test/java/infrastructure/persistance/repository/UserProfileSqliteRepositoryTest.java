package infrastructure.persistance.repository;

import domain.user.UserId;
import domain.user.UserProfile;
import infrastructure.persistance.dao.UserDao;
import infrastructure.persistance.dto.UserDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class UserProfileSqliteRepositoryTest {

	private static final String NAME   ="Bob";
	private static final String LAST_NAME  = "Sponge";
	private static final String USERNAME   ="LeSponge";

	private UserSqliteRepository userSqliteRepository;

	@Mock
	private UserDao userDao;
	@Mock
	private UserAssembler userAssembler;
	private UserProfile userProfile;
	private UserDto userDto;
	private UserId userId;


	@Before
	public void setUp(){
		userProfile = new UserProfile(userId,NAME,LAST_NAME,USERNAME);
		userSqliteRepository = new UserSqliteRepository(userDao,userAssembler);
	}

	@Test
	public void whenSavingANewUser_thenTheAssemblerSerializeItToADatabaseFormat()throws Exception{
		userSqliteRepository.save(userProfile);

		verify(userAssembler).assemble(userProfile);
	}

	@Test
	public void whenSavingANewUser_thenDelegateSavingToTheDao()throws Exception{
		userSqliteRepository.save(userProfile);

		verify(userDao).save(userDto);
	}
}
