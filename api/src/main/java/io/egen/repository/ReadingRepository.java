package io.egen.repository;


import io.egen.entity.Reading;


import java.util.List;

public interface ReadingRepository {

    List<Reading> findAll();

    Reading findOne(String vin);

    Reading create(Reading reading);

    Reading update( Reading reading);

    void delete(Reading reading);
}
