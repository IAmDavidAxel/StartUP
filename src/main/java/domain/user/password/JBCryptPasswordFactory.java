package domain.user.password;

import application.user.IllegalPasswordFormatException;

public class JBCryptPasswordFactory implements PasswordFactory {

	private PasswordPolicy passwordPolicy;

	public JBCryptPasswordFactory(PasswordPolicy passwordPolicy) {
		this.passwordPolicy = passwordPolicy;
	}

	@Override
	public Password create(String plainPassword) throws IllegalPasswordFormatException {
		if (passwordPolicy.isValid(plainPassword)){
			return new Password(plainPassword);
		}
		else {
			throw new IllegalPasswordFormatException();
		}
	}
}
