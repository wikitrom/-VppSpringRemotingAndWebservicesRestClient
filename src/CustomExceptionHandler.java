import java.io.IOException;
import java.util.List;

import org.springframework.http.MediaType;
// import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

public class CustomExceptionHandler extends DefaultResponseErrorHandler {

	private List<HttpMessageConverter<?>> converters;

	// -- constructors --
	public CustomExceptionHandler(RestTemplate template) {
		converters = template.getMessageConverters();
	}

	// -- methods --

	// method triggered when an exception is thrown
	@Override
	public void handleError(ClientHttpResponse response) throws IOException {

		// if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
		// throw new ResourceNotFoundException();
		// }

		// take the returned body and convert it into a java class
		MediaType mediaType = response.getHeaders().getContentType();
		ErrorInformation error = null;
		for (HttpMessageConverter next : converters) {

			if (next.canRead(ErrorInformation.class, mediaType)) {

				error = (ErrorInformation) next.read(ErrorInformation.class, response);
			}
		}

		switch (response.getStatusCode()) {
		case NOT_FOUND: // why does this work? How do the compiler know which NOT_FOUND I want? Probably
						// because of extends DefaultResponseErrorHandler
			throw new ResourceNotFoundException(error);

		default:
			throw new UnexpectedHttpErrorException(error);
		}

		// finally we throw an exception for any other error not handled above
		// throw new UnexpectedHttpErrorException();
	}

}
