package api.user;

import application.user.ServiceException;
import application.user.AccountantService;

public class AccountantJsonResource {
	private AccountantService accountantService;

	public AccountantJsonResource(AccountantService accountantService) {

		this.accountantService = accountantService;
	}

	public void create(AccountantDto accountantDto) throws ServiceException {

		accountantService.create(accountantDto);
	}

}
