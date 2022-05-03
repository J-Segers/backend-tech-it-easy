package nl.novi.les.springboot.backendtechiteasy.models.dtos;

import nl.novi.les.springboot.backendtechiteasy.models.entities.RemoteControl;

public class RemoteControlInputDto {

    public String compatibleWith;
    public String batteryType;
    public String brand;
    public Double price;
    public Integer originalStock;

    public static RemoteControl toRemoteControl(RemoteControlInputDto remoteControlInputDto) {
        RemoteControl remoteControl = new RemoteControl();

         remoteControl.setCompatibleWith(remoteControlInputDto.compatibleWith);
         remoteControl.setBatteryType(remoteControlInputDto.batteryType);
         remoteControl.setBrand(remoteControlInputDto.brand);
         remoteControl.setPrice(remoteControlInputDto.price);
         remoteControl.setOriginalStock(remoteControlInputDto.originalStock);

        return remoteControl;
    }
}
