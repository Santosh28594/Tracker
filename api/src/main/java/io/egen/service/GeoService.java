package io.egen.service;


import io.egen.entity.Geo;
import io.egen.entity.Reading;

import java.util.List;

public interface GeoService {

    List<Geo> getGeo();

    List<Geo> getGeoByVin(String vin);

    void create(Reading read);
}
