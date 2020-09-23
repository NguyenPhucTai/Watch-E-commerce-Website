package phuctai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import phuctai.entity.Brand;

@Repository
public interface BrandRepository  extends JpaRepository<Brand, Long>{
	Brand findByBrandName(String brandName);
}
