package pl.eiti.auth.domain.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.eiti.auth.domain.entity.User;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    public User findByUsernameAndPassword(String username,String password);
    public User findOneByUsername(String username);

}
