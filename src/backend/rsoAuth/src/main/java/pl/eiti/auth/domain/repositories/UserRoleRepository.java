package pl.eiti.auth.domain.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.eiti.auth.domain.entity.UserRole;

public interface UserRoleRepository extends CrudRepository<UserRole, Long> {
}
