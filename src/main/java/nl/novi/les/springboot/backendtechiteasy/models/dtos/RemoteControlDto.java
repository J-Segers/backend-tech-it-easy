package nl.novi.les.springboot.backendtechiteasy.models.dtos;

import nl.novi.les.springboot.backendtechiteasy.models.entities.RemoteControl;
import nl.novi.les.springboot.backendtechiteasy.models.entities.RemoteControl;

public class RemoteControlDto {

    public Long id;
    public String compatibleWith;
    public String batteryType;
    public String brand;
    public Double price;
    public Integer originalStock;

    public static RemoteControlDto fromRemoteControl(RemoteControl remoteControl) {
        RemoteControlDto remoteControlDto = new RemoteControlDto();

        remoteControlDto.id = remoteControl.getId();
        remoteControlDto.compatibleWith = remoteControl.getCompatibleWith();
        remoteControlDto.batteryType = remoteControl.getBatteryType();
        remoteControlDto.brand = remoteControl.getBrand();
        remoteControlDto.price = remoteControl.getPrice();
        remoteControlDto.originalStock = remoteControl.getOriginalStock();

        return remoteControlDto;
    }
}
