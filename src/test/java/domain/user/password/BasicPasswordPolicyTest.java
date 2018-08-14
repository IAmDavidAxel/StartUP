package domain.user.password;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BasicPasswordPolicyTest {

	private static final String GOOD_LENGTH = "GoodLove33§";
	private static final String BAD_LENGTH = "Bobo78*";
	private static final String GOOD_PATTERN = "Wint3rIsC0ming!";
	private static final String BAD_PATTERN = "badPattern";
	private static final String VALID = "B4RCeL0n4!!!**";
	private static final String NOT_VALID = "hahahpasvalidedutout";

	private BasicPasswordPolicy basicPolicy;

	@Before
	public void setUp(){
		basicPolicy = new BasicPasswordPolicy();
	}

	@Test
	public void whenTestingGoodLength_thenReturnTrue(){

		boolean isValidLength =basicPolicy.isValidLength(GOOD_LENGTH);

		assertTrue(isValidLength);
	}

	@Test
	public void whenTestingBadLength_thenReturnFalse(){
		boolean isValidLength = basicPolicy.isValidLength(BAD_LENGTH);

		assertFalse(isValidLength);
	}

	@Test
	public void whenTestingGoodPattern_thenReturnTrue()throws Exception{
		boolean isValidPattern = basicPolicy.isValidPattern(GOOD_PATTERN);

		assertTrue(isValidPattern);
	}

	@Test
	public void whenTestingABadPattern_thenReturnFalse(){
		boolean isValidPattern = basicPolicy.isValidPattern(BAD_PATTERN);

		assertFalse(isValidPattern);
	}

	@Test
	public void whenPasswordIsValid_thenReturnTrue(){
		boolean isValid = basicPolicy.isValid(VALID);

		assertTrue(isValid);
	}

	@Test
	public void whenPasswordIsNotValid_thenReturnFalse(){
		boolean isValid = basicPolicy.isValid(NOT_VALID);

		assertFalse(isValid);
	}

}