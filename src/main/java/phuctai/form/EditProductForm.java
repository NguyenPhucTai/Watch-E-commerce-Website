package phuctai.form;

import javax.validation.constraints.NotBlank;

import phuctai.entity.Product;

public class EditProductForm {

	private Long id;
	private String productName;
	private String productDetail;
	private Long price;
	private String linkImg;
	private String cateName;
	
	public EditProductForm() {
		super();
	}
	public EditProductForm(String productName, String productDetail, Long price, String linkImg, String category) {
		super();
		this.productName = productName;
		this.productDetail = productDetail;
		this.price = price;
		this.linkImg = linkImg;
		this.cateName = category;
	}
	public EditProductForm(Product Product) {
		this.id = Product.getId();
		this.productName = Product.getProductName();
		this.productDetail = Product.getProductDetail();
		this.price = Product.getPrice();
		this.linkImg = Product.getLinkImg();

		
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
	public String getCategory() {
		return cateName;
	}
	public void setCategory(String category) {
		this.cateName = category;
	}
	@Override
	public String toString() {
		return "EditProductForm [id=" + id + ", productName=" + productName + ", productDetail=" + productDetail
				+ ", price=" + price + ", linkImg=" + linkImg + ", category=" + cateName + "]";
	}


	
	
	
	
	
}
