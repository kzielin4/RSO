package pl.eiti.auth.domain.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.eiti.auth.domain.entity.User;


public interface UserRepository extends CrudRepository<User, Long> {
}
