package pl.eiti.rso.domain.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.eiti.rso.domain.entity.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
