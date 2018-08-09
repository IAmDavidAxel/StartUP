package application.user;

import api.user.UserDto;
import domain.user.User;
import domain.user.UserRepository;

public class UserService {
	private final UserAssembler userAssembler;
	private final UserRepository userRepository;

	public UserService(UserAssembler userAssembler, UserRepository userRepository) {

		this.userAssembler = userAssembler;
		this.userRepository = userRepository;
	}

	public void create(UserDto userDto) throws ServiceException{

	User user = userAssembler.assemble(userDto);

		userRepository.save(user);

	}
}
