package nl.novi.les.springboot.backendtechiteasy.models.dtos;

import nl.novi.les.springboot.backendtechiteasy.models.entities.WallBracket;

public class WallBracketDto {
    public Long id;
    public String size;
    public Boolean adjustable;
    public String name;
    public Double price;

    public static WallBracketDto fromWallBracket(WallBracket wallBracket) {
        WallBracketDto wallBracketDto = new WallBracketDto();

        wallBracketDto.id = wallBracket.getId();
        wallBracketDto.size = wallBracket.getSize();
        wallBracketDto.adjustable = wallBracket.getAdjustable();
        wallBracketDto.name = wallBracket.getName();
        wallBracketDto.price = wallBracket.getPrice();

        return wallBracketDto;
    }
}
