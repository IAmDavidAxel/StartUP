package application.exception;

import application.user.ServiceException;
import domain.StartUPDomainException;

public class EntityCreationServiceCreation extends ServiceException {

	public EntityCreationServiceCreation(StartUPDomainException cause) {
		super(cause);
	}
}
