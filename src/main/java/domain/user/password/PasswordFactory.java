package domain.user.password;

import application.user.IllegalPasswordFormatException;
import domain.user.password.Password;

public interface PasswordFactory {

	 Password create(String plainPassword) throws IllegalPasswordFormatException;
}
