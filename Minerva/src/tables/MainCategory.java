package tables;

import java.util.List;

@Entity
public class MainCategory {
	@id
	@GenericGenerator(name = "generator", strategy = "increment") 
    @GeneratedValue(generator = "generator")
	private long id;
	private String name;
	private List<SubCategory> subCategories;

	

	public MainCategory() {
	}

	public long getId() {
		return id;
	}

	private void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@OneToMany(targetEntity=SubCategory.class, mappedBy="mainCategory")
	public List<SubCategory> getSubCategories() {
		return subCategories;
	}
}
