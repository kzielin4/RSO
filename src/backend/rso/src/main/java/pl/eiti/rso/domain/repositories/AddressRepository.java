package pl.eiti.rso.domain.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.eiti.rso.domain.entity.Address;

public interface AddressRepository extends CrudRepository<Address, Long> {
}
