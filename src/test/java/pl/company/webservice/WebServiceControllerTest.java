package pl.company.webservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import pl.company.entity.Material;
import pl.company.entity.MaterialDetails;
import pl.company.service.CompanyService;
import pl.company.service.MaterialDetailsService;
import pl.company.service.MaterialService;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * Created by wronskip on 11.08.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(CompanyWebService.class)
public class WebServiceControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    MaterialService materialService;

    @MockBean
    CompanyService companyService;

    @MockBean
    MaterialDetailsService materialDetailsService;

    @Test
    @WithMockUser(username="admin",password = "password" )
    public void getMaterialById() throws Exception
    {

        Material mockMaterial = new Material();
        mockMaterial.setId(1L);
        mockMaterial.setName("Copper");
        MaterialDetails materialDetails = new MaterialDetails();
        materialDetails.setColour("red");
        materialDetails.setPrice(100.0);
        materialDetails.setId(1L);
        materialDetails.setWeight("2");
        mockMaterial.setMaterialDetails(materialDetails);

        given(materialService.getMaterialById(1L)).willReturn(mockMaterial);
        this.mockMvc.perform(get("/materialList?companyID=1")).andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));

    }
}
