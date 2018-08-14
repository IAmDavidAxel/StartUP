package api.user;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountantDto {

	@JsonProperty(value ="first_name")
	private String firstName;

	@JsonProperty(value ="last_name")
	private String lastName;

	@JsonProperty(value = "password")
	private String password;

	@JsonProperty(value = "username")
	private String username;

	@JsonProperty(value = "email")
	private String email;


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
