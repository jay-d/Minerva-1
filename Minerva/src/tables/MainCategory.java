package tables;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class MainCategory {
	@Id
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
