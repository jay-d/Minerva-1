package tables;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class User {
	private long thirdPartId;
	@Id
	@GenericGenerator(name = "generator", strategy = "increment") 
    @GeneratedValue(generator = "generator")
	private long id;
	private String email;
	
	@ManyToOne
	@JoinColumn(name="profileID")
	private Profile profile;

	public User() {
	}

	public long getThirdPartId() {
		return thirdPartId;
	}

	public void setThirdPartId(long thirdPartId) {
		this.thirdPartId = thirdPartId;
	}

	public long getId() {
		return id;
	}

	private void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}
}
