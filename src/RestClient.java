import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

public class RestClient {

	public static void main(String[] args) throws IOException {

		String myURL = "http://localhost:8080/mywebapp/customer/CS03939cc";
		RestTemplate template = new RestTemplate();
		template.setErrorHandler(new CustomExceptionHandler());

		List<MediaType> acceptedMediaTypes = new ArrayList<MediaType>();
		acceptedMediaTypes.add(MediaType.IMAGE_JPEG);
		acceptedMediaTypes.add(MediaType.APPLICATION_XML);
		// acceptedMediaTypes.add(MediaType.APPLICATION_JSON);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(acceptedMediaTypes);

		// getForObject can not be used if we want to provide specific http-headers
		HttpEntity requestEntity = new HttpEntity(headers);

		try {
			HttpEntity response = template.exchange(myURL, HttpMethod.GET, requestEntity, String.class);
			// System.out.println(response);
			System.out.println("Successfully found customer: " + response.getBody());

		} catch (ResourceNotFoundException e) { // HTTP 404
			System.out.println("Customer not found");
		}
	}

}
