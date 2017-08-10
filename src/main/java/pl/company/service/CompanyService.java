package pl.company.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.company.entity.Company;
import pl.company.repository.CompanyRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wronskip on 09.08.2017.
 */
@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;



    public List<Company> findAllCompanies(){
        List<Company> companies = new ArrayList<>();
        this.companyRepository.findAll().forEach(company->companies.add(company));
        return companies;
    }

    public Company findCompanyById(Long companyId){
     return this.companyRepository.findOne(companyId);

    }

}
