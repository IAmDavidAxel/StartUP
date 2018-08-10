package domain.user;

public class UserProfile {

	private UserId userId;
	private  String name;
	private  String lastName;
	private  String username;

	public UserProfile(UserId userId, String name, String lastName, String username) {
		this.userId = userId;
		this.name = name;
		this.lastName = lastName;
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public String getLastName() {
		return this.lastName;
	}

	public String getUsername() {
		return this.username;
	}
}
