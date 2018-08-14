package domain.user.credential;

import domain.user.accessLevel.AccessLevel;
import domain.user.password.Password;
import domain.user.token.Token;

public class CredentialFactory {
	public Credential create(Password password, Token token, AccessLevel accountant) {

		return new Credential();
	}
}
