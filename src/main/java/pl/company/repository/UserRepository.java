package pl.company.repository;

import org.springframework.data.repository.CrudRepository;
import pl.company.entity.User;

/**
 * Created by wronskip on 08.08.2017.
 */
public interface UserRepository extends CrudRepository<User, Long> {
}
