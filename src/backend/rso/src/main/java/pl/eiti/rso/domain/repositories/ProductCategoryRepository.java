package pl.eiti.rso.domain.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.eiti.rso.domain.entity.ProductCategory;

public interface ProductCategoryRepository extends CrudRepository<ProductCategory, Long> {
}
