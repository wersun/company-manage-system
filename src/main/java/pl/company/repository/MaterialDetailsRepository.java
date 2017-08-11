package pl.company.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.company.entity.MaterialDetails;

/**
 * Created by wronskip on 08.08.2017.
 * Repository for MaterialDetails pojos, including db operations.
 */
@Repository
public interface MaterialDetailsRepository extends CrudRepository<MaterialDetails, Long> {
}
