package io.egen.service;


import io.egen.entity.Alert;
import io.egen.entity.Reading;

import java.util.List;

public interface AlertsService {


    void checkinAlerts(Reading reading);

    List<Alert> findAlerts();

    List<Alert> findByVin(String vin);

}
