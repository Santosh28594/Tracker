package io.egen.entity;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity/*Entity to Show Alerts*/
public class Alert {

    /*Constructor to call Alert and Assign values to variables */
    public Alert(Reading reading, String prior, String alertName){
        this.reading=reading;
        this.priority=prior;
        this.alertName=alertName;
    }
    @Id/*primary key*/
    @GeneratedValue(strategy = IDENTITY)
    private Integer alertId;

    @ManyToOne(fetch = FetchType.LAZY)/*Many to one mapping b/w Alerts to Readings*/
    @JoinColumn(name = "readid", nullable = false)
    private Reading reading;



    private String priority;

    private String alertName;

    public Integer getAlertId() {
        return alertId;
    }

    public void setAlertId(Integer alertId) {
        this.alertId = alertId;
    }

    public Reading getReading() {
        return reading;
    }

    public void setReading(Reading reading) {
        this.reading = reading;
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
