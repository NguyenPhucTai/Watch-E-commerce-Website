package phuctai.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import phuctai.entity.Product;
import phuctai.entity.Brand;
import phuctai.entity.Category;
import phuctai.repository.ProductRepository;
import phuctai.repository.BrandRepository;
import phuctai.repository.CategoryRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private BrandRepository brandRepository;

	
	
	public List<Product> getProductListByTop6() {
		List<Product> list = productRepository.findTop6ByOrderByPriceAsc();
		return list;
	}

	public List<Product> getAllProduct() {
		List<Product> list = productRepository.findAll();
		return list;
	}

	public List<Product> listAll(String productKey) {
		if (productKey != null) {
			return productRepository.search(productKey);
		}
		return productRepository.findAll();
	}

	public Product findByProductName(String productName) {
		Product Product = productRepository.findByProductName(productName);
		return Product;
	}

	public void save(Product product, String categoryName) {
		
		Brand brand = brandRepository.findByBrandName("HUBLOT");
		product.setBrands(brand);

		productRepository.save(product);
		Product newProduct = productRepository.findByProductName(product.getProductName());
		Category category = categoryRepository.findByCateName(categoryName);
		
		newProduct.getCategories().add(category);
		productRepository.save(newProduct);

	}

	public Page<Product> findAllProduct(int pageNumb, String sortField, String sortDir) {

		PageRequest pageable = PageRequest.of(pageNumb - 1, 9,
				sortDir.equals("asc") ? Sort.by(sortField).ascending() : Sort.by(sortField).descending());
		return productRepository.findAll(pageable);
	}
	public Page<Product> findAllProductByCategory(int pageNumb, String sortField, String sortDir){
		PageRequest pageable = PageRequest.of(pageNumb - 1, 9,
				sortDir.equals("asc") ? Sort.by(sortField).ascending() : Sort.by(sortField).descending());
		return productRepository.findAll(pageable);
	}
	public Optional<Product> findById(Long id) {
		return productRepository.findById(id);
	}
	
	public void deleteProduct(String productName) {
		Product product = productRepository.findByProductName(productName);
		productRepository.delete(product);
		
	}
}
