package domain.user;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class UserProfileFactoryTest {

	private static final String NAME   ="Bob";
	private static final String LAST_NAME  = "Sponge";
	private static final String USERNAME   ="LeSponge";

	private UserProfileFactory userProfileFactory;
	private UserId  userId;

	@Before
	public void setUp(){
		userProfileFactory = new UserProfileFactory();
	}

	@Test
	public void givenParameters_whenCreating_thenReturnNewUserProfile()throws Exception{

		UserProfile profileFromFactory =userProfileFactory.create(userId,NAME,LAST_NAME,USERNAME);

		String name = profileFromFactory.getName();
		String lastName = profileFromFactory.getLastName();
		String username = profileFromFactory.getUsername();

	assertEquals(name,NAME);
	assertEquals(lastName,LAST_NAME);
	assertEquals(username,USERNAME);

	}

}