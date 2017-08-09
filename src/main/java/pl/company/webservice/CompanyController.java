package pl.company.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.company.entity.Company;
import pl.company.repository.CompanyRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wronskip on 09.08.2017.
 */
@RestController
public class CompanyController {

    @Autowired
    private CompanyRepository companyRepository;


    @RequestMapping(value = "companyList", method = RequestMethod.GET)
    List<Company> findAllCompanies(){
        List<Company> companies = new ArrayList<>();
        this.companyRepository.findAll().forEach(company->companies.add(company));
        return companies;
    }


}
