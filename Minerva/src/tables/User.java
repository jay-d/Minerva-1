package tables;

@Entity
public class User {
	private long thirdPartId;
	@id
	@GenericGenerator(name = "generator", strategy = "increment") 
    @GeneratedValue(generator = "generator")
	private long id;
	private String email;
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
	@ManyToOne
	@JoinColumn(name="profileID")
	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}
}
