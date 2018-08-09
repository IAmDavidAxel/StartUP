package infrastructure.persistance.repository;

import domain.user.User;
import infrastructure.persistance.dto.UserDto;

public interface UserDao {
	void save(UserDto userDto);

}
