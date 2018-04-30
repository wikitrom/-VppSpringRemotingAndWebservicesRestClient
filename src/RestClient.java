
import java.io.IOException;
import java.net.URI;

import org.springframework.hateoas.Link;
import org.springframework.web.client.RestTemplate;

public class RestClient {

	public static void main(String[] args) throws IOException {

		String customerURI = "http://localhost:8080/mywebapp/customer/CS03939";
		String collectionURI = "http://localhost:8080/mywebapp/customers";

		RestTemplate template = new RestTemplate();
//		template.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
		template.setErrorHandler(new CustomExceptionHandler(template));

		CustomerCollectionRepresentation allCustomers = template.getForObject(collectionURI + "?first=1&last=2", CustomerCollectionRepresentation.class);
		
		Link link = allCustomers.getLink("next");
		System.out.println("Next page link: " + link.getHref());
		
	}

}
