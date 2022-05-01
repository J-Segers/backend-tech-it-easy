package nl.novi.les.springboot.backendtechiteasy.models.dtos;

import nl.novi.les.springboot.backendtechiteasy.models.entities.Television;
import org.hibernate.validator.constraints.Length;

public class TelevisionDto {

    public Long id;

    @Length(min = 5, max = 50)
    public String type;

    @Length(min = 2, max = 25)
    public String brand;

    @Length(min = 5, max = 50)
    public String name;

    public Double price;

    public static TelevisionDto fromTelevision(Television television) {
        TelevisionDto televisionDto = new TelevisionDto();
        televisionDto.id = television.getId();
        televisionDto.type = television.getType();
        televisionDto.brand = television.getBrand();
        televisionDto.name = television.getName();
        televisionDto.price = television.getPrice();

        return televisionDto;
    }
}
