package Liste_exception;

public class ExisteException extends Exception{

	public ExisteException(String message) {
		super(message);
		System.out.println(message);
		
	}

}
