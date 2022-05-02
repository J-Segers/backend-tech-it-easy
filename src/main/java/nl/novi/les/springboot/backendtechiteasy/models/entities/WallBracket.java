package nl.novi.les.springboot.backendtechiteasy.models.entities;

import javax.persistence.*;

@Entity
public class WallBracket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String size;

    @Column
    private Boolean adjustable;

    @Column
    private String name;

    @Column
    private Double price;

    public WallBracket() {
    }

    public WallBracket(Long id, String size, Boolean adjustable, String name, Double price) {
        this.id = id;
        this.size = size;
        this.adjustable = adjustable;
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Boolean getAdjustable() {
        return adjustable;
    }

    public void setAdjustable(Boolean adjustable) {
        this.adjustable = adjustable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
