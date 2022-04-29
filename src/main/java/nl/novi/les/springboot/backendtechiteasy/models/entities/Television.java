package nl.novi.les.springboot.backendtechiteasy.models.entities;

import javax.persistence.*;

@Entity
public class Television {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 50)
    private String type;

    @Column(length =25)
    private String brand;

    @Column(length = 50)
    private String name;

    @Column
    private double price;

//    @Column(name = "availableSize")
//    double availableSize;
//
//    @Column(name = "refreshRate")
//    double refreshRate;
//
//    @Column(name = "screenType")
//    String screenType;
//
//    @Column(name = "screenQuality")
//    String screenQuality;
//
//    @Column(name = "smartTv")
//    boolean smartTv;
//
//    @Column(name = "wifi")
//    boolean wifi;
//
//    @Column(name = "voiceControl")
//    boolean voiceControl;
//
//    @Column(name = "hdr")
//    boolean hdr;
//
//    @Column(name = "bluetooth")
//    boolean bluetooth;
//
//    @Column(name = "ambiLight")
//    boolean ambiLight;
//
//    @Column(name = "originalStock")
//    int originalStock;
//
//    @Column(name = "sold")
//    int sold;

    public Television() {
    }

    public Television(String type, String brand, String name, double price) {

        this.type = type;
        this.brand = brand;
        this.name = name;
        this.price = price;

    }

    public long getId() {
        return id;
    }

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

//    public double getAvailableSize() {
//        return availableSize;
//    }
//
//    public void setAvailableSize(double availableSize) {
//        this.availableSize = availableSize;
//    }
//
//    public double getRefreshRate() {
//        return refreshRate;
//    }
//
//    public void setRefreshRate(double refreshRate) {
//        this.refreshRate = refreshRate;
//    }
//
//    public String getScreenType() {
//        return screenType;
//    }
//
//    public void setScreenType(String screenType) {
//        this.screenType = screenType;
//    }
//
//    public String getScreenQuality() {
//        return screenQuality;
//    }
//
//    public void setScreenQuality(String screenQuality) {
//        this.screenQuality = screenQuality;
//    }
//
//    public boolean isSmartTv() {
//        return smartTv;
//    }
//
//    public void setSmartTv(boolean smartTv) {
//        this.smartTv = smartTv;
//    }
//
//    public boolean isWifi() {
//        return wifi;
//    }
//
//    public void setWifi(boolean wifi) {
//        this.wifi = wifi;
//    }
//
//    public boolean isVoiceControl() {
//        return voiceControl;
//    }
//
//    public void setVoiceControl(boolean voiceControl) {
//        this.voiceControl = voiceControl;
//    }
//
//    public boolean isHdr() {
//        return hdr;
//    }
//
//    public void setHdr(boolean hdr) {
//        this.hdr = hdr;
//    }
//
//    public boolean isBluetooth() {
//        return bluetooth;
//    }
//
//    public void setBluetooth(boolean bluetooth) {
//        this.bluetooth = bluetooth;
//    }
//
//    public boolean isAmbiLight() {
//        return ambiLight;
//    }
//
//    public void setAmbiLight(boolean ambiLight) {
//        this.ambiLight = ambiLight;
//    }
//
//    public int getOriginalStock() {
//        return originalStock;
//    }
//
//    public void setOriginalStock(int originalStock) {
//        this.originalStock = originalStock;
//    }
//
//    public int getSold() {
//        return sold;
//    }
//
//    public void setSold(int sold) {
//        this.sold = sold;
//    }
}
