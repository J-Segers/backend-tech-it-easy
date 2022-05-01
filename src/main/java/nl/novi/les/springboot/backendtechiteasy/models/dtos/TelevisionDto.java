package nl.novi.les.springboot.backendtechiteasy.models.dtos;

import org.hibernate.validator.constraints.Length;

public class TelevisionDto {

    @Length(min = 5, max = 50)
    private String type;

    @Length(min = 2, max = 25)
    private String brand;

    @Length(min = 5, max = 50)
    private String name;

    private Double price;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
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

    public void setPrice(double price) {
        this.price = price;
    }
}
