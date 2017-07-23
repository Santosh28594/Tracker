package io.egen.service;

import io.egen.entity.Geo;
import io.egen.entity.Reading;
import io.egen.exception.ResourceNotFoundException;

import io.egen.repository.GeoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GeoServiceImpl implements GeoService {

   @Autowired
    GeoRepository geoRepository;

    @Transactional(readOnly = true)
    public List<Geo> getGeo() {
        return geoRepository.getGeo();
    }

    @Transactional(readOnly = true)
    public List<Geo> getGeoByVin(String vin) {
        return geoRepository.getGeoByVin(vin);
    }

    @Transactional
    public void create(Reading read) {

        Geo geo= new Geo(read.getVe().getVin(), read.getLatitude(), read.getLongitude(),read.getTimestamp());

        geoRepository.create(geo);
    }
}
