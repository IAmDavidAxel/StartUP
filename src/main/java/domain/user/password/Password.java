package domain.user.password;

import org.mindrot.jbcrypt.BCrypt;

public class Password {
	private String digest;

	public Password(String userPassword) {
		generate(userPassword);
	}

	public Password(){

	}

	public void generate(String plainPassword){
		this.digest = BCrypt.hashpw(plainPassword,BCrypt.gensalt());
	}

	public String getDigest() {
		return digest;
	}

	public void setDigest(String digest) {
		this.digest = digest;
	}

	public void verify(String plainPassword) throws MismatchedPasswordException{

		boolean valid = BCrypt.checkpw(plainPassword,digest);

		if(!valid){
			throw new MismatchedPasswordException();
		}
	}


}
