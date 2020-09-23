package phuctai.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import phuctai.form.CreateProductForm;

@Entity
@Table(name="Product")
public class Product {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String productName;
	private String productDetail;
	private Long price;
	private String linkImg;
	
	
	
	  @ManyToOne(fetch = FetchType.LAZY, optional = false)
	  @JoinColumn(name = "brand_id", nullable = false)
	  protected Brand brands;
	  
	  
	  @ManyToMany(fetch = FetchType.LAZY,
	            cascade = {
	                CascadeType.PERSIST,
	                CascadeType.MERGE
	            })
	   @JoinTable(name = "product_category",
	            joinColumns = { @JoinColumn(name = "product_id") },
	            inverseJoinColumns = { @JoinColumn(name = "category_id") })
		private Set<Category> categories = new HashSet<>();

		public Product() {}
		
		public Product(String productName, String productDetail, Long price, String linkImg) {
			super();
			this.productName = productName;
			this.productDetail = productDetail;
			this.price = price;
			this.linkImg = linkImg;
		}

		public Product(Long id, String productName, String productDetail, Long price, String linkImg) {
			super();
			this.id = id;
			this.productName = productName;
			this.productDetail = productDetail;
			this.price = price;
			this.linkImg = linkImg;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getProductName() {
			return productName;
		}

		public void setProductName(String productName) {
			this.productName = productName;
		}

		public String getProductDetail() {
			return productDetail;
		}

		public void setProductDetail(String productDetail) {
			this.productDetail = productDetail;
		}

		public Long getPrice() {
			return price;
		}

		public void setPrice(Long price) {
			this.price = price;
		}

		public String getLinkImg() {
			return linkImg;
		}

		public void setLinkImg(String linkImg) {
			this.linkImg = linkImg;
		}

		public Brand getBrands() {
			return brands;
		}

		public void setBrands(Brand brands) {
			this.brands = brands;
		}

		public Set<Category> getCategories() {
			return categories;
		}

		public void setCategories(Set<Category> categories) {
			this.categories = categories;
		}
		
		@Override
		public String toString() {
			return "Product [id=" + id + ", productName=" + productName + ", productDetail=" + productDetail
					+ ", price=" + price + ", linkImg=" + linkImg + ", Brands=" + brands + "]";
		}
	
}