package pl.company.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.company.entity.Material;
import pl.company.repository.CompanyRepository;
import pl.company.repository.MaterialRepository;
import pl.company.service.MaterialService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wronskip on 09.08.2017.
 */
@RestController
public class MaterialController {

    @Autowired
    private MaterialService materialService;


    @RequestMapping(value = "materialList", method = RequestMethod.GET)
    List<Material> getMaterialsByCompanyId(@RequestParam(name = "companyID", required = false) String companyId){
        List<Material> materials = new ArrayList<>();
        if(companyId==null){
            return materialService.getAllMaterials();
        }else{
            return materialService.getMaterialsByCompanyId(Long.valueOf(companyId));
        }

    }
}
