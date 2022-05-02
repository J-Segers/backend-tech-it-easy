package nl.novi.les.springboot.backendtechiteasy.models.dtos;

import nl.novi.les.springboot.backendtechiteasy.models.entities.CIModule;
import nl.novi.les.springboot.backendtechiteasy.models.entities.Television;

public class CIModuleDto {
    public Long id;
    public String name;
    public String type;
    public Double price;

    public static CIModuleDto fromCIModel(CIModule ciModule) {
        CIModuleDto ciModuleDto = new CIModuleDto();

        ciModuleDto.id = ciModule.getId();
        ciModuleDto.name = ciModule.getName();
        ciModuleDto.type = ciModule.getType();
        ciModuleDto.price = ciModule.getPrice();

        return ciModuleDto;
    }
}
