package io.egen.entity;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "Vehicle.findAll", query = "Select veh from Vehicle veh Order by veh.model desc"),
        @NamedQuery(name = "Vehicle.findByModel", query = "Select veh from Vehicle veh where veh.model=:paramModel ")
})
public class Vehicle {
    @Id
    private String vin;

    private String make;
    private String model;
    private int year;
    private int redlineRpm;
    private int maxFuelVolume;
    private Timestamp lastServiceDate;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Reading> reading;

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getRedlineRpm() {
        return redlineRpm;
    }

    public void setRedlineRpm(int redlineRpm) {
        this.redlineRpm = redlineRpm;
    }

    public int getMaxFuelVolume() {
        return maxFuelVolume;
    }

    public void setMaxFuelVolume(int maxFuelVolume) {
        this.maxFuelVolume = maxFuelVolume;
    }

    public Timestamp getLastServiceDate() {
        return lastServiceDate;
    }

    public void setLastServiceDate(Timestamp lastServiceDate) {
        this.lastServiceDate = lastServiceDate;
    }

    public List<Reading> getReading() {
        return reading;
    }

    public void setReading(List<Reading> reading) {
        this.reading = reading;
    }
}
