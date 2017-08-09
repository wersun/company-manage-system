package pl.company.entity;


import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by wronskip on 08.08.2017.
 */
@Entity
public class Material implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_material")
    private Long id;

    private String name;

    @OneToOne
    private MaterialDetails materialDetails;





    public Material() {
    }

    public Material(String name, MaterialDetails materialDetails) {
        this.name = name;
        this.materialDetails = materialDetails;
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

    public MaterialDetails getMaterialDetails() {
        return materialDetails;
    }

    public void setMaterialDetails(MaterialDetails materialDetails) {
        this.materialDetails = materialDetails;
    }
}
