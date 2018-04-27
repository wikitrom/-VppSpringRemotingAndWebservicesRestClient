import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@XmlRootElement(name = "customer")
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerClientVersion {

	@XmlElement(name = "companyName")
	private String name;
	private String customerId;
	private String notes;
	private String email;
	private String telephone;
	private List<CallClientVersion> calls;

	public String getCompanyName() {
		return name;
	}

	public void setCompanyName(String companyName) {
		this.name = companyName;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String toString() {
		return "id: " + customerId + " customer: " + name;
	}
}
