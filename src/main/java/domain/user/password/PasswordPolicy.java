package domain.user.password;

public interface PasswordPolicy {

	boolean isValid(String plainPassword);

	boolean isValidPattern(String plainPassword);

	boolean isValidLength (String plainPassword);

}
