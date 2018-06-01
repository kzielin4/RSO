package pl.eiti.rso.domain.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.eiti.rso.domain.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
