package pl.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import pl.company.entity.Company;
import pl.company.entity.Material;
import pl.company.entity.MaterialDetails;
import pl.company.service.CompanyService;
import pl.company.service.MaterialService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wronskip on 09.08.2017.
 * Main view controller contains navigations between templates and control post/get operations.
 */
@org.springframework.stereotype.Controller
public class CompanyController {

    private List<Company> companyList;
    private List<Material> allMaterials;
    private Material currentMaterial;


    @Autowired
    private CompanyService companyService;

    @Autowired
    private MaterialService materialService;

    /**
     *
     * @param model
     * @return return companies template with model in it.
     */
    @GetMapping(value = "companies")
    public String init(Model model){
        if(companyList==null) {
            companyList = getAllCompanies();
        }
        model.addAttribute("companies", companyList);
        return "companies";
    }


    /**
     *
     * @param companyId
     * @param model
     * @return template with list of materials with model for specified company Id.
     */
    @GetMapping(value = "company/{id}")
    public String showMaterials(@PathVariable(value = "id") String companyId,Model model){
        Company currentCompany = companyList.stream().filter(company -> company.getId() == Long.valueOf(companyId)).findFirst().get();
        List<Material> materials = currentCompany.getMaterials();
        model.addAttribute("materials", materials);
        model.addAttribute("company",currentCompany);
        return "materials";
    }

    /**
     *
     * @param materialId
     * @param model
     * @return details template with model for specified material Id .
     */
    @GetMapping(value = "materials/{materialId}/details")
    public String showMaterialDetails(@PathVariable(value = "materialId") String materialId,Model model){
        allMaterials = new ArrayList<>();
        companyList.stream().forEach(company -> allMaterials.addAll(company.getMaterials()));
        currentMaterial = allMaterials.stream().filter(material -> material.getId() == Long.valueOf(materialId)).findFirst().get();
        model.addAttribute("material",currentMaterial);
        model.addAttribute("details", currentMaterial.getMaterialDetails());
        return "details";
    }

    @PostMapping(value = "save")
    public String processForm(@ModelAttribute(value="details") MaterialDetails details) {
        MaterialDetails currentMaterialDetails = currentMaterial.getMaterialDetails();
        currentMaterialDetails.setColour(details.getColour());
        currentMaterialDetails.setPrice(details.getPrice());
        currentMaterialDetails.setWeight(details.getWeight());
        return "redirect:materials/"+currentMaterial.getId() + "/details";
    }

    @PostMapping(value = "revert")
    public String processForm() {
        companyList = getAllCompanies();
        companyList.stream().forEach(company -> allMaterials.addAll(company.getMaterials()));
        return "redirect:companies";
    }



    private List<Company> getAllCompanies() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Company[]> responseEntity=restTemplate.getForEntity("http://localhost:8337/companyList",Company[].class );
        return Arrays.asList(responseEntity.getBody());
    }
}
