package sokovnik.exception;

public class PremasenBrojMogucihAkcijaException extends Exception{

	/**
	 * 
	 * The PremasenBrojMogucihAkcijaException happens when Sokovnik reaches the limit of potential actions. 
	 * 
	 * @author MGajin
	 */
	private static final long serialVersionUID = -4145824386868024999L;

		public PremasenBrojMogucihAkcijaException(String message) {
			super(message);
		}
	
}
