package domain.user.password;

import domain.StartUPDomainException;

public class MismatchedPasswordException extends StartUPDomainException {

	public MismatchedPasswordException(){
		super("the password you provided does not match the one in the system");
	}
}
