package pl.company.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.company.entity.Company;

/**
 * Created by wronskip on 08.08.2017.
 * Repository for Company pojos, including db operations.
 */
@Repository
public interface CompanyRepository extends CrudRepository<Company, Long>{
}
