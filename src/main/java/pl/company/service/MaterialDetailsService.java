package pl.company.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.company.entity.MaterialDetails;
import pl.company.repository.MaterialRepository;

/**
 * Created by wronskip on 09.08.2017.
 */
@Service
public class MaterialDetailsService {

    @Autowired
    private MaterialRepository materialRepository;

    public MaterialDetails getDetailsByMaterialId(Long materialId){
        return this.materialRepository.findOne(materialId).getMaterialDetails();
    }
}
