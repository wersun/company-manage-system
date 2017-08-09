package pl.company.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.company.entity.MaterialDetails;
import pl.company.repository.MaterialRepository;

/**
 * Created by wronskip on 09.08.2017.
 */
@RestController
public class MaterialDetailsController {

    @Autowired
    private MaterialRepository materialRepository;

    @RequestMapping(value = "materialDetails", method = RequestMethod.GET)
    MaterialDetails getDetailsByMaterialId(@RequestParam(name = "ID", required = true) String materialId){
        return this.materialRepository.findOne(Long.valueOf(materialId)).getMaterialDetails();
    }
}
