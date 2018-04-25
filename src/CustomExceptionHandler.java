import java.io.IOException;

// import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;

public class CustomExceptionHandler extends DefaultResponseErrorHandler {

	@Override
	public void handleError(ClientHttpResponse response) throws IOException {
		// triggered when an exception is thrown

		// if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
		// throw new ResourceNotFoundException();
		// }

		switch (response.getStatusCode()) {
		case NOT_FOUND: // why does this work? How do the compiler know which NOT_FOUND I want? Probably
						// because of extends DefaultResponseErrorHandler
			throw new ResourceNotFoundException();

		default:
			throw new UnexpectedHttpErrorException();
		}

		// finally we throw an exception for any other error not handled above
		// throw new UnexpectedHttpErrorException();
	}

}
