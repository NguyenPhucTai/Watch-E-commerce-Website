package phuctai.form;

import phuctai.entity.Product;

public class CreateProductForm {

	private Long id;
	private String productName;
	private String productDetail;
	private Long price;
	private String linkImg;
	private String cateName;
	
	public CreateProductForm(Long id, String productName, String productDetail, Long price, String linkImg,
			String cateName) {
		super();
		this.id = id;
		this.productName = productName;
		this.productDetail = productDetail;
		this.price = price;
		this.linkImg = linkImg;
		this.cateName = cateName;
	}

	public CreateProductForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CreateProductForm(Product product) {
		this.id = product.getId();
		this.productName = product.getProductName();
		this.productDetail = product.getProductDetail();
		this.price = product.getPrice();
		this.linkImg = product.getLinkImg();
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

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

	@Override
	public String toString() {
		return "CreateProductForm [id=" + id + ", productName=" + productName + ", productDetail=" + productDetail
				+ ", price=" + price + ", linkImg=" + linkImg + ", cateName=" + cateName + "]";
	}
}
