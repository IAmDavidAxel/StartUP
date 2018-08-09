package infrastructure.persistance.repository;

import domain.user.User;
import infrastructure.persistance.dto.UserDto;

public class UserSqliteRepository {

	private UserDao userDao;
	private UserAssembler userAssembler;

	public UserSqliteRepository(UserDao userDao, UserAssembler userAssembler) {

		this.userDao = userDao;
		this.userAssembler = userAssembler;
	}

	public void save(User user) {

		UserDto userDto = userAssembler.assemble(user);

		userDao.save(userDto);

	}
}
