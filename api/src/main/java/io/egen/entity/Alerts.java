package io.egen.entity;


import javax.persistence.Entity;

@Entity
public class Alerts {

    private String high;
    private String medium;
    private String low;

    public String getHigh() {
        return "High";
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getMedium() {
        return "Medium";
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getLow() {
        return "Low";
    }


    public void setLow(String low) {
        this.low = low;
    }
}
