package phuctai.repository;

import phuctai.entity.Product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

	List<Product> findTop6ByOrderByPriceAsc();
	List<Product> findAll();
	Product findByProductName(String productName);
	
	//nativeQuery
    @Query("SELECT p FROM Product p WHERE product_name LIKE %?1%")
    public List<Product> search(String productKey);
}
