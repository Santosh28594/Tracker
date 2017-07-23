package io.egen.repository;

import io.egen.entity.Geo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class GeoRepositoryImpl implements GeoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Geo> getGeo() {
        TypedQuery<Geo> query = entityManager.createNamedQuery("Geo.getGeo", Geo.class);
        return query.getResultList();
    }

    @Override
    public List<Geo> getGeoByVin(String vin) {
        TypedQuery<Geo> query = entityManager.createNamedQuery("Geo.getGeoByVin", Geo.class);
        query.setParameter("paramVin", vin);
        List<Geo> resutList = query.getResultList();
        if(resutList!= null){
            return resutList;
        }
        else {
            return null;
        }
    }

    @Override
    public String create(Geo geo) {
        entityManager.persist(geo);
        return "";
    }
}
