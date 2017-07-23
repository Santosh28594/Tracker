package io.egen.repository;

import io.egen.entity.Geo;

import java.util.List;

public interface GeoRepository {

    List<Geo> getGeo();

    List<Geo> getGeoByVin(String vin);

    String create(Geo geo);
}
