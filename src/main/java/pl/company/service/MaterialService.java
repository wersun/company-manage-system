package pl.company.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.company.entity.Material;
import pl.company.repository.CompanyRepository;
import pl.company.repository.MaterialRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wronskip on 09.08.2017.
 *
 */
@Service
public class MaterialService {

    @Autowired
    private MaterialRepository materialRepository;

    @Autowired
    private CompanyRepository companyRepository;

    /**
     *
     * @return Method return list of all materials available.
     */
    public List<Material> getAllMaterials() {
        List<Material> materials = new ArrayList<>();
        this.materialRepository.findAll().forEach(material -> materials.add(material));
        return materials;
    }

    /**
     *
     * @param companyId
     * @return list of materials for specified company Id.
     */
    public List<Material> getMaterialsByCompanyId(Long companyId) {
        return this.companyRepository.findOne(companyId).getMaterials();
    }

    /**
     *
     * @param materialId
     * @return material for specified material id.
     */
    public Material getMaterialById(Long materialId) {
        return this.materialRepository.findOne(materialId);
    }
}