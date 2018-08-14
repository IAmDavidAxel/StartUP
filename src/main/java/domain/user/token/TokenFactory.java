package domain.user.token;

import org.joda.time.DateTime;

public class TokenFactory {

	public Token create() {
		DateTime dateTime = new DateTime();
		return new Token(dateTime);
	}
}
