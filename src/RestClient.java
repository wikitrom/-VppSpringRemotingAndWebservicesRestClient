import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class RestClient {

	public static void main(String[] args) throws IOException {

		String myURL = "http://localhost:8080/mywebapp/customer/CS03939";
		RestTemplate template = new RestTemplate();

		List<MediaType> acceptedMediaTypes = new ArrayList<MediaType>();
		acceptedMediaTypes.add(MediaType.IMAGE_JPEG);
		// acceptedMediaTypes.add(MediaType.APPLICATION_XML);
		acceptedMediaTypes.add(MediaType.APPLICATION_JSON);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(acceptedMediaTypes);

		// getForObject can not be used if we want to provide specific http-headers
		HttpEntity requestEntity = new HttpEntity(headers);
		HttpEntity response = template.exchange(myURL, HttpMethod.GET, requestEntity, String.class);

		System.out.println(response);
		System.out.println();
		System.out.println(response.getBody());
		System.out.println();

		CustomerClientVersion customer = template.getForObject(myURL, CustomerClientVersion.class);

		System.out.println("Customer : " + customer.getCompanyName() + " (id: " + customer.getCustomerId()
				+ ")\nNotes: " + customer.getNotes());

	}
}
