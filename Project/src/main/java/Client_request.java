import java.util.Date;

public class Client_request {
    private String username;
    private String fabricType;
    private int sampleQuantity;
    private String contact;
    private Date date;
    
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFabricType() {
		return fabricType;
	}
	public void setFabricType(String fabricType) {
		this.fabricType = fabricType;
	}
	public int getSampleQuantity() {
		return sampleQuantity;
	}
	public void setSampleQuantity(int sampleQuantity) {
		this.sampleQuantity = sampleQuantity;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public Date getDate() {
		return date;
	}
	   public void setDate(Date date) {
	        this.date = date;
	}

    // Add getters and setters for the fields
}
