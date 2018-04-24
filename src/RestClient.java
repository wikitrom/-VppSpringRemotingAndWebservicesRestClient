import java.io.IOException;

import org.springframework.web.client.RestTemplate;

public class RestClient {

	public static void main(String[] args) throws IOException {

		RestTemplate template = new RestTemplate();
		String response = template.getForObject("http://localhost:8080/mywebapp/customer/CS03939", String.class);
		System.out.println(response);
		System.out.println();

		CustomerClientVersion customer = template.getForObject("http://localhost:8080/mywebapp/customer/CS03939", CustomerClientVersion.class);

		System.out.println("Customer : " + customer.getCompanyName() + " (id: " + customer.getCustomerId()
				+ ")\nNotes: " + customer.getNotes());

	}
}
