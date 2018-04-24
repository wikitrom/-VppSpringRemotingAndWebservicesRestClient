import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="customer")
public class CustomerClientVersion {

	@XmlElement(name="companyName")
	private String name;
	private String customerId;
	private String notes;
	
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
	
	
}
