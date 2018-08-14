package application.user;

import api.user.AccountantDto;
import application.exception.EntityCreationServiceCreation;
import domain.user.AccountantRepository;
import domain.user.accountant.Accountant;

public class AccountantService {
	private AccountantFactory accountantFactory;
	private AccountantRepository accountantRepository;

	public AccountantService(AccountantFactory accountantFactory, AccountantRepository accountantRepository) {

		this.accountantFactory = accountantFactory;
		this.accountantRepository = accountantRepository;
	}

	public void create(AccountantDto accountantDto) throws ServiceException{

		Accountant accountant = createAccountant(accountantDto);

		accountantRepository.save(accountant);

	}

	private Accountant createAccountant(AccountantDto accountantDto) throws ServiceException {

		try{
			return accountantFactory.create(accountantDto);
		}catch (IllegalPasswordFormatException e){
			throw  new EntityCreationServiceCreation(e);
		}

	}
}
