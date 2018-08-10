package application.user;

import api.user.AccountantDto;
import domain.user.UserProfile;
import domain.user.UserRepository;

public class UserService {
	private  UserAssembler userAssembler;
	private  UserRepository userRepository;

	public UserService(UserAssembler userAssembler, UserRepository userRepository) {

		this.userAssembler = userAssembler;
		this.userRepository = userRepository;
	}

	public void create(AccountantDto accountantDto) throws ServiceException{

	UserProfile userProfile = userAssembler.assemble(accountantDto);

		userRepository.save(userProfile);

	}
}
