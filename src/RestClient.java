
import java.io.IOException;
import java.net.URI;

import org.springframework.web.client.RestTemplate;

public class RestClient {

	public static void main(String[] args) throws IOException {

		String customerURI = "http://localhost:8080/mywebapp/customer/CS03939";
		String collectionURI = "http://localhost:8080/mywebapp/customers";

		RestTemplate template = new RestTemplate();
//		template.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
		template.setErrorHandler(new CustomExceptionHandler(template));

		CustomerClientVersion customer = new CustomerClientVersion();
		customer.setCompanyName("Apple");
		customer.setNotes("almost as bad ad MS");
		
		URI finalLocation =  template.postForLocation(collectionURI, customer);
//		System.out.println(finalLocation);
		
		CustomerClientVersion foundCustomer = template.getForObject(finalLocation, CustomerClientVersion.class);
		System.out.println(foundCustomer);
		
	}

}
