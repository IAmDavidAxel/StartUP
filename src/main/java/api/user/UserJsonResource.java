package api.user;

import application.user.ServiceException;
import application.user.UserService;

public class UserJsonResource {
	private UserService userService;

	public UserJsonResource(UserService userService) {

		this.userService = userService;
	}

	public void create(AccountantDto accountantDto) throws ServiceException {

		userService.create(accountantDto);
	}

}
