
public class ResourceNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3102416493852744662L;
	private ErrorInformation error;

	public ResourceNotFoundException(ErrorInformation error) {
		this.error = error;
	}

	
	
	public ErrorInformation getErrorObject() {
		return this.error;
	}
}
