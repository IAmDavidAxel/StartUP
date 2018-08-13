package server;

public class UnknowModeServerException extends RuntimeException {

	public UnknowModeServerException(){
		super("Unknown running mode");
	}
}
