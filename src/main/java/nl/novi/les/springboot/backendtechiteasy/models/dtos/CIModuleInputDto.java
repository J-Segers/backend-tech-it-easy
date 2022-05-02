package nl.novi.les.springboot.backendtechiteasy.models.dtos;

import nl.novi.les.springboot.backendtechiteasy.models.entities.CIModule;

public class CIModuleInputDto {
    public String name;
    public String type;
    public Double price;

    public static CIModule toCIModel(CIModule ciModule) {
        CIModuleInputDto ciModuleDto = new CIModuleInputDto();

        ciModuleDto.name = ciModule.getName();
        ciModuleDto.type = ciModule.getType();
        ciModuleDto.price = ciModule.getPrice();

        return ciModule;
    }
}
