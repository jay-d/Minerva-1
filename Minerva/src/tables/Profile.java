package tables;

import java.awt.Image;

public class Profile {
	private long userId;
//	private Image image;
	private String information;
	private String location;
	private String lastName;
	private String firstName;

	public Profile() {
	}

	public long getUserId() {
		return userId;
	}

	private void setUserId(long userId) {
		this.userId = userId;
	}

//	public Image getImage() {
//		return image;
//	}

//	public void setImage(Image image) {
//		this.image = image;
//	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
}
