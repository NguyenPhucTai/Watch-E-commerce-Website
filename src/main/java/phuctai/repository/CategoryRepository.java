package phuctai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import phuctai.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
	List<Category> findAll();
	List<Category> findByCateNameContaining(String categoryKey);
	Category findByCateName(String cateName);
	
}
