package nl.novi.les.springboot.backendtechiteasy.models.dtos;

import nl.novi.les.springboot.backendtechiteasy.models.entities.Television;
import org.hibernate.validator.constraints.Length;

public class TelevisionInputDto {

    @Length(min = 5, max = 50)
    public String type;

    @Length(min = 2, max = 25)
    public String brand;

    @Length(min = 5, max = 50)
    public String name;

    public Double price;

    public static Television toTelevision(TelevisionInputDto inputDto) {
        Television television = new Television();

        television.setType(inputDto.type);
        television.setBrand(inputDto.brand);
        television.setName(inputDto.name);
        television.setPrice(inputDto.price);

        return television;
    }

    public void printObject() {

        System.out.println("type: " + type);
        System.out.println("brand: " + brand);
        System.out.println("name: " + name);
        System.out.println("price: " + price);

    }

}
