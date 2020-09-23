package phuctai.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="Brand")
public class Brand {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	
	private String brandName;
	
	@OneToMany(mappedBy = "brands", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
	private Set<Product> Products ;
	
	
	public Brand() {}
	
	
	public Brand(String brandName) {
		super();
		this.brandName = brandName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	
	
}