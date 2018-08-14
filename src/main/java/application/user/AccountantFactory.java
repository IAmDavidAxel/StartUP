package application.user;

import api.user.AccountantDto;
import domain.user.UserId;
import domain.user.UserProfile;
import domain.user.UserProfileFactory;
import domain.user.accessLevel.AccessLevel;
import domain.user.accountant.Accountant;
import domain.user.credential.Credential;
import domain.user.credential.CredentialFactory;
import domain.user.identifier.UserIdFactory;
import domain.user.password.Password;
import domain.user.password.PasswordFactory;
import domain.user.token.Token;
import domain.user.token.TokenFactory;

public class AccountantFactory {

	private UserIdFactory userIdFactory;
	private UserProfileFactory userProfileFactory;
	private PasswordFactory passwordFactory;
	private TokenFactory tokenFactory;
	private CredentialFactory credentialFactory;

	public AccountantFactory(UserIdFactory userIdFactory, UserProfileFactory userProfileFactory,PasswordFactory passwordFactory, TokenFactory tokenFactory,CredentialFactory credentialFactory) {
		this.userIdFactory = userIdFactory;
		this.userProfileFactory = userProfileFactory;
		this.passwordFactory = passwordFactory;
		this.tokenFactory = tokenFactory;
		this.credentialFactory = credentialFactory;
	}

	public Accountant create(AccountantDto accountantDto) throws IllegalPasswordFormatException {
		UserId userId = userIdFactory.create();

		String lastName = accountantDto.getLastName();
		String firstName = accountantDto.getFirstName();
		String userName = accountantDto.getUsername();
		String password = accountantDto.getPassword();
		String email = accountantDto.getEmail();

		UserProfile userProfile = userProfileFactory.create(userId,lastName,firstName,userName);

		Password passwordFronFactory = passwordFactory.create(password);
		Token token = tokenFactory.create();

		Credential credential  = credentialFactory.create(passwordFronFactory,token,AccessLevel.ACCOUNTANT);


		return new Accountant(userProfile,credential,email);
	}
}
