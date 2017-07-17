package io.egen.repository;


import io.egen.entity.Alert;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class AlertsRepositoryImpl implements AlertsRepository{


@PersistenceContext
    EntityManager entityManager;

    public String create(Alert alert) {
        entityManager.persist(alert);
        return "";
    }
}
