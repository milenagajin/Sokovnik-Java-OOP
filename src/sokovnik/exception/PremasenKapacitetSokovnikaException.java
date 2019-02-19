package sokovnik.exception;

public class PremasenKapacitetSokovnikaException extends Exception{

	/**
	 * The PremasenKapacitetSokovnikaException is thrown when PosudaZaVoce reaches the maximum of its capacity.
	 * @author MGajin
	 */
	private static final long serialVersionUID = 3114865143754802415L;
	
	
	public PremasenKapacitetSokovnikaException(String message) {
		super(message);
	}

}
