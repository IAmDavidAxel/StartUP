package infrastructure.persistance.dao;

import infrastructure.persistance.dao.sqlite.DaoInternalException;
import infrastructure.persistance.dto.UserDto;

public interface UserDao {
	void save(UserDto userDto) throws DaoInternalException;

}
