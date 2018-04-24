import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class RestClient {

	public static void main(String[] args) throws IOException {

		URL url = new URL("http://localhost:8080/mywebapp/customer/CS03939");
		InputStream is = url.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		System.out.println(br.readLine());
	}

}
