package io.egen.repository;


import io.egen.entity.Alert;

import java.util.List;

public interface AlertsRepository {

    String create(Alert alert);

    public List<Alert> findAlerts();
    List<Alert> findByVin(String vin);
}
