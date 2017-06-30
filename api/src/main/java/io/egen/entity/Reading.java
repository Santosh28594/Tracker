package io.egen.entity;


import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.*;
import java.sql.Timestamp;


/*Readings Entity*/
@Entity
@NamedQueries({
        @NamedQuery(name = "Reading.findAll", query = "Select read from Reading read")})
public class Reading {

    @Id/*Auto Generated Primary key*/
    @GeneratedValue(strategy = IDENTITY)
    private Integer readid;

    /*Many to One mapping b/w Reading to Vehicles*/
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vin", nullable = false)/*Foreign Key*/
    private Vehicle ve;

    @Transient/*To be invisible in Reading Entity*/
    private String vin;


    private double latitude;
    private double longitude;
    private Timestamp timestamp;
    private double fuelVolume;
    private int speed;
    private int engineHp;
    private boolean checkEngineLightOn;
    private boolean engineCoolantLow;
    private boolean cruiseControlOn;
    private int engineRpm;
    @Embedded/*Part of Reading Entity but a different object*/
    private Tires tires;


    /*Getters and setters of reading entity variables*/
    public Integer getReadid() {
        return readid;
    }

    public void setReadid(Integer readid) {
        this.readid = readid;
    }

    public Vehicle getVe() {
        return ve;
    }

    public void setVe(Vehicle ve) {
        this.ve = ve;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public double getFuelVolume() {
        return fuelVolume;
    }

    public void setFuelVolume(double fuelVolume) {
        this.fuelVolume = fuelVolume;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getEngineHp() {
        return engineHp;
    }

    public void setEngineHp(int engineHp) {
        this.engineHp = engineHp;
    }

    public boolean isCheckEngineLightOn() {
        return checkEngineLightOn;
    }

    public void setCheckEngineLightOn(boolean checkEngineLightOn) {
        this.checkEngineLightOn = checkEngineLightOn;
    }

    public boolean isEngineCoolantLow() {
        return engineCoolantLow;
    }

    public void setEngineCoolantLow(boolean engineCoolantLow) {
        this.engineCoolantLow = engineCoolantLow;
    }

    public boolean isCruiseControlOn() {
        return cruiseControlOn;
    }

    public void setCruiseControlOn(boolean cruiseControlOn) {
        this.cruiseControlOn = cruiseControlOn;
    }

    public int getEngineRpm() {
        return engineRpm;
    }

    public void setEngineRpm(int engineRpm) {
        this.engineRpm = engineRpm;
    }

    public Tires getTires() {
        return tires;
    }

    public void setTires(Tires tires) {
        this.tires = tires;
    }

    /*toString() for testing*/
    @Override
    public String toString() {
        return "Reading{" +
                "vin='" + vin + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", timestamp=" + timestamp +
                ", fuelVolume=" + fuelVolume +
                ", speed=" + speed +
                ", engineHp=" + engineHp +
                ", checkEngineLightOn=" + checkEngineLightOn +
                ", engineCoolantLow=" + engineCoolantLow +
                ", cruiseControlOn=" + cruiseControlOn +
                ", engineRpm=" + engineRpm +
                ", tires=" + tires +
                ", readid=" + readid +

                '}';
    }
}
