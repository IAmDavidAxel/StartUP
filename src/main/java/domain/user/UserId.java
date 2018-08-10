package domain.user;

import java.util.UUID;

public class UserId {

	private String id;

	public UserId(){
		generateIdValue();
	}

	private void generateIdValue() {
		this.id = UUID.randomUUID().toString();
	}


	public String getIdValue() {
		return id;
	}
}
