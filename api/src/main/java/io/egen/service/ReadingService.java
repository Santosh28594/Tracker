package io.egen.service;


import io.egen.entity.Reading;


import java.util.List;

public interface ReadingService {

    List<Reading> findAll();

   //Reading findOne(String vin);

    List<Reading> findByVinId(String VinId);

    Reading create(Reading reading);

    Reading update(Reading reading);

    void delete(String vin);

}
