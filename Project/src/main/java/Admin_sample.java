import java.util.Date;

public class Admin_sample {

	private int price;
	private String username;
	private Date date;
	public String imageFileName;
	private int hexValue;
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public int getHexValue() {
		return hexValue;
	}

	public void setHexValue(int hexValue) {
		this.hexValue = hexValue;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
