package application.user;

import domain.StartUPDomainException;

public class IllegalPasswordFormatException extends StartUPDomainException {

	public IllegalPasswordFormatException() {
		super("Your password does not respect our Policies :( :( :(");
	}
}
