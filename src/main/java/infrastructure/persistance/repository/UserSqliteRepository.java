package infrastructure.persistance.repository;

import domain.user.UserProfile;
import infrastructure.persistance.dao.UserDao;
import infrastructure.persistance.dao.sqlite.DaoInternalException;
import infrastructure.persistance.dto.UserDto;

public class UserSqliteRepository {

	private UserDao userDao;
	private UserAssembler userAssembler;

	public UserSqliteRepository(UserDao userDao, UserAssembler userAssembler) {

		this.userDao = userDao;
		this.userAssembler = userAssembler;
	}

	public void save(UserProfile userProfile) throws DaoInternalException {

		UserDto userDto = userAssembler.assemble(userProfile);

		userDao.save(userDto);

	}
}
