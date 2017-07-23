package io.egen.repository;


import io.egen.entity.Reading;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;


@Repository
public class ReadingRepositoryImpl implements ReadingRepository {

    @PersistenceContext
    private EntityManager entityManager;


    public List<Reading> findAll() {
        TypedQuery<Reading> query = entityManager.createNamedQuery("Reading.findAll",Reading.class);
        return query.getResultList();
    }


    public List<Reading> findByVinId(String VinId) {
        TypedQuery<Reading> query = entityManager.createNamedQuery("Reading.findByVinId", Reading.class);
        query.setParameter("paramVinId", VinId);
        List<Reading> resutList = query.getResultList();
        if(resutList!= null){
            return resutList;
        }
        else {
            return null;
        }
    }


    public Reading findOne(String vin) {
        return entityManager.find(Reading.class,vin);
    }


    public Reading create(Reading reading) {

        entityManager.persist(reading);
        return reading;
    }

    public Reading update(Reading reading) {
        return entityManager.merge(reading);
    }

    public void delete(Reading reading) {
        entityManager.remove(reading);
    }
}
