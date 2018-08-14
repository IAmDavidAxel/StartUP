package domain.user.accountant;

import domain.user.UserProfile;
import domain.user.credential.Credential;

public class Accountant {
	private UserProfile userProfile;

	public Accountant(UserProfile userProfile, Credential credential, String email) {

		this.userProfile = userProfile;
	}
}
