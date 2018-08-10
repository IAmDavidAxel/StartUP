package domain.user;

public class UserProfileFactory {
	public UserProfile create(UserId userId, String name, String lastName, String username) {
		return new UserProfile(userId,name,lastName,username);
	}
}
