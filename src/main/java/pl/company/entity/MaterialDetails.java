package pl.company.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by wronskip on 08.08.2017.
 */
@Entity
public class MaterialDetails implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String colour;

    private String weight;

    private Double price;

    public MaterialDetails() {
    }

    public MaterialDetails(String colour, String weight, Double price) {
        this.colour = colour;
        this.weight = weight;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }



    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
