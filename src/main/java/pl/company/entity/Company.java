package pl.company.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by wronskip on 08.08.2017.
 */
@Entity
public class Company implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_company")
    private Long id;

    private String name;

    @OneToMany
    @JoinColumn(name = "company_id", referencedColumnName="id_company")
    private List<Material> materials;

    public Company() {
    }

    public Company(String name, List<Material> materials) {
        this.name = name;
        this.materials = materials;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Material> getMaterials() {
        return materials;
    }

    public void setMaterials(List<Material> materials) {
        this.materials = materials;
    }
}
