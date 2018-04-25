
public class UnexpectedHttpErrorException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1637991647851360574L;
	private ErrorInformation error;

	public UnexpectedHttpErrorException(ErrorInformation error) {
		this.error = error;
	}

	public ErrorInformation getErrorObject() {
		return this.error;
	}

}
