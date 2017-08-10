package pl.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
 */
@org.springframework.stereotype.Controller
public class Controller {


    @Autowired
    private CompanyService companyService;

    @Autowired
    private MaterialService materialService;

    @GetMapping(value = "home")
    public String init(Model model){
    List<Company> list = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add(
                new BasicAuthorizationInterceptor("user", "haslo"));
        ResponseEntity<Company[]> responseEntity=restTemplate.getForEntity("http://localhost:8337/companyList",Company[].class );
        List<Company> companies = Arrays.asList(responseEntity.getBody());
        model.addAttribute("companies", companies);
        return "companies";
    }


    @GetMapping(value = "company/{id}")
    public String showMaterials(@PathVariable(value = "id") String companyId,Model model){
        List<Material> list = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();
        Company company = companyService.findCompanyById(Long.valueOf(companyId));
        restTemplate.getInterceptors().add(
                new BasicAuthorizationInterceptor("user", "haslo"));
        ResponseEntity<Material[]> responseEntity=restTemplate.getForEntity("http://localhost:8337/materialList?companyID=" + companyId,Material[].class );
        List<Material> materials = Arrays.asList(responseEntity.getBody());
        model.addAttribute("materials", materials);
        model.addAttribute("company",company);
        return "materials";
    }

    @GetMapping(value = "materials/{materialId}/details")
    public String showMaterialDetails(@PathVariable(value = "materialId") String materialId,Model model){
        List<Material> list = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add(
                new BasicAuthorizationInterceptor("user", "haslo"));
        MaterialDetails details=restTemplate.getForObject("http://localhost:8337/materialDetails?ID=" + materialId,MaterialDetails.class );
        Material material = materialService.getMaterialById(Long.valueOf(materialId));
        model.addAttribute("material",material);
        model.addAttribute("details", details);
        return "details";
    }
}
