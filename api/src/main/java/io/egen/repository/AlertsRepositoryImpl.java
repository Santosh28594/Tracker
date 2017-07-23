package io.egen.repository;


import io.egen.entity.Alert;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class AlertsRepositoryImpl implements AlertsRepository{


@PersistenceContext
    private EntityManager entityManager;

    public String create(Alert alert) {
        entityManager.persist(alert);
        return "";
    }


    public List<Alert> findAlerts() {
        TypedQuery<Alert> query = entityManager.createNamedQuery("Alert.findAlerts", Alert.class);
        return query.getResultList();
    }


    public List<Alert> findByVin(String vin) {
        TypedQuery<Alert> query = entityManager.createNamedQuery("Alert.findByVin", Alert.class);
        query.setParameter("paramVin", vin);
        List<Alert> resultList = query.getResultList();
        if(resultList!= null){
            return resultList;
        }
        else {
            return null;
        }
    }
}
