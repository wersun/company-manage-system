package pl.company.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.company.entity.Company;
import pl.company.entity.Material;
import pl.company.entity.MaterialDetails;
import pl.company.service.CompanyService;
import pl.company.service.MaterialDetailsService;
import pl.company.service.MaterialService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wronskip on 10.08.2017.
 */
@RestController
public class CompanyWebService {

    @Autowired
    private CompanyService companyService;
    @Autowired
    private MaterialService materialService;

    @Autowired
    private MaterialDetailsService materialDetailsService;



    @RequestMapping(value = "companyList", method = RequestMethod.GET)
    List<Company> findAllCompanies(){
        return companyService.findAllCompanies();
    }


    @RequestMapping(value = "materialList", method = RequestMethod.GET)
    List<Material> getMaterialsByCompanyId(@RequestParam(name = "companyID", required = false) String companyId){
        List<Material> materials = new ArrayList<>();
        if(companyId==null){
            return materialService.getAllMaterials();
        }else{
            return materialService.getMaterialsByCompanyId(Long.valueOf(companyId));
        }

    }

    @RequestMapping(value = "materialDetails", method = RequestMethod.GET)
    MaterialDetails getDetailsByMaterialId(@RequestParam(name = "ID", required = true) String materialId){
        return this.materialDetailsService.getDetailsByMaterialId(Long.valueOf(materialId));
    }
}
