package phuctai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import phuctai.entity.Category;
import phuctai.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> getAllCategory(){
		return categoryRepository.findAll();
	}

	public List<Category> listAll(String categoryKey) {
		if(categoryKey != null) {
			return categoryRepository.findByCateNameContaining(categoryKey);
		}
		return categoryRepository.findAll();
	}

	public void save(String cateName) {
		List<Category> cateList = categoryRepository.findAll();
		boolean check = true;
		for(Category category : cateList) {
			if(category.getCateName().equalsIgnoreCase(cateName)) {
				check = false;
			}
		}
		if(check == true) {
			Category newCategory = new Category();
			newCategory.setCateName(cateName);
			categoryRepository.save(newCategory);
		}else {
			System.out.println("Đã tồn tại");
		}

		
	}
	
	

	public void deleteCategory(String categoryName) {
		Category category = categoryRepository.findByCateName(categoryName);
		categoryRepository.delete(category);
	}

	public Category findByCategoyName(String cateName) {
		Category category = categoryRepository.findByCateName(cateName);
		return category;
	}

	public void save(Category category) {
		categoryRepository.save(category);
	}
	
	
}
