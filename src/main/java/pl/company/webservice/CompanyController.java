package pl.company.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.company.entity.Company;
import pl.company.repository.CompanyRepository;
import pl.company.service.CompanyService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wronskip on 09.08.2017.
 */
@RestController
public class CompanyController {

    @Autowired
    private CompanyService service;


    @RequestMapping(value = "companyList", method = RequestMethod.GET)
    List<Company> findAllCompanies(){
        return service.findAllCompanies();
    }


}
