package nl.novi.les.springboot.backendtechiteasy.models.dtos;

import nl.novi.les.springboot.backendtechiteasy.models.entities.WallBracket;

public class WallBracketInputDto {
    public Long id;
    public String size;
    public Boolean adjustable;
    public String name;
    public Double price;

    public static WallBracket toWallBracket(WallBracketInputDto wallBracketInputDto) {
        WallBracket wallBracket = new WallBracket();

        wallBracket.setId(wallBracketInputDto.id);
        wallBracket.setSize(wallBracketInputDto.size);
        wallBracket.setAdjustable(wallBracketInputDto.adjustable);
        wallBracket.setName(wallBracketInputDto.name);
        wallBracket.setPrice(wallBracketInputDto.price);

        return wallBracket;
    }
}
