package pl.company.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.company.entity.Material;

import java.util.List;

/**
 * Created by wronskip on 08.08.2017.
 * Repository for Material pojos, including db operations.
 */
@Repository
public interface MaterialRepository extends CrudRepository<Material, Long> {
}
