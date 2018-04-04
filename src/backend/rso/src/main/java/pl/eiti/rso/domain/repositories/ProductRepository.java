package pl.eiti.rso.domain.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.eiti.rso.domain.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
