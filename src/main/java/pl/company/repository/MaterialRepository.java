package pl.company.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.company.entity.Material;

/**
 * Created by wronskip on 08.08.2017.
 */
@Repository
public interface MaterialRepository extends CrudRepository<Material, Long> {
}
