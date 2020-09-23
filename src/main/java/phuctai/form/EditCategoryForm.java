package phuctai.form;

public class EditCategoryForm {

	private Long id;
	private String cateName;
	public EditCategoryForm(Long id, String cateName) {
		super();
		this.id = id;
		this.cateName = cateName;
	}
	public EditCategoryForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCateName() {
		return cateName;
	}
	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
	@Override
	public String toString() {
		return "EditCategoryForm [id=" + id + ", cateName=" + cateName + "]";
	}
	
	
}
