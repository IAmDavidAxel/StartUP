package domain.user.password;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BasicPasswordPolicy implements PasswordPolicy {

	private static final  int MINIMUM_PASSWORD_LENGTH = 8;

	@Override
	public boolean isValid(String plainPassword) {
		return isValidLength(plainPassword) && isValidPattern(plainPassword);
	}

	@Override
	public boolean isValidPattern(String plainPassword) {

		Pattern passwordPolicyPattern = Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#<>_\\$%\\^&\\*]).*)");

		Matcher passwordPatternMatcher = passwordPolicyPattern.matcher(plainPassword);

		return passwordPatternMatcher.matches();
	}

	@Override
	public boolean isValidLength(String plainPassword) {
		return plainPassword.length() >= MINIMUM_PASSWORD_LENGTH;
	}
}
