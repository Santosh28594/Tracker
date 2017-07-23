package io.egen.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import java.sql.Date;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.criteria.CriteriaBuilder;


import java.sql.Timestamp;

import static javax.persistence.GenerationType.IDENTITY;

@Entity/*Entity to Show Alerts*/

@NamedQueries({
        @NamedQuery(name = "Alert.findAlerts",query = "select alert from Alert alert"), //Query to find all readings data
        @NamedQuery(name = "Alert.findByVin",query = "select alert from Alert alert where alert.vin=:paramVin")
})
public class Alert {

    public Alert(){

    }

    /*Constructor to call Alert and Assign values to variables */
    public Alert(Reading reading, String prior, String alertName, String vin){
        this.read=reading;
        this.priority=prior;
        this.vin = vin;
        this.alertName=alertName;
        this.datetime=new java.sql.Timestamp(new java.util.Date().getTime());

    }
    @Id/*primary key*/
    @GeneratedValue(strategy = IDENTITY)
    private Integer alertId;

    @ManyToOne(fetch = FetchType.LAZY)/*Many to one mapping b/w Alerts to Readings*/
    @JoinColumn(name = "readid", nullable = false)
    @JsonIgnore
    private Reading read;



    private Timestamp datetime;


    private String vin;

    @Transient
    private Integer readid;

    private String priority;

    private String alertName;

    public Reading getRead() {
        return read;
    }

    public void setRead(Reading read) {
        this.read = read;
    }

    public Timestamp getDatetime() {
        return datetime;
    }

    public void setDatetime(Timestamp datetime) {
        this.datetime = datetime;
    }






    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Integer getReadid() {
        return readid;
    }

    public void setReadid(Integer readid) {
        this.readid = readid;
    }



    public Integer getAlertId() {
        return alertId;
    }

    public void setAlertId(Integer alertId) {
        this.alertId = alertId;
    }



    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getAlertName() {
        return alertName;
    }

    public void setAlertName(String alertName) {
        this.alertName = alertName;
    }
}
