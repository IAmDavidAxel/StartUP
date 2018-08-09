package infrastructure.persistance.entityManager;

public class EntityManagerException extends Exception {

	public EntityManagerException(){
		super("An internal persistence transaction error has occurred");
	}
}
