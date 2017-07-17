package io.egen.service;



import io.egen.entity.Reading;
import io.egen.entity.Vehicle;
import io.egen.exception.ResourceNotFoundException;
import io.egen.repository.ReadingRepository;
import io.egen.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReadingServiceImpl implements ReadingService{

    @Autowired
    ReadingRepository readingRepository;

    @Autowired
    VehicleRepository repository;

    @Autowired
    AlertsService alertsService;

    @Transactional(readOnly = true)
    public List<Reading> findAll() {
        return readingRepository.findAll();
    }
    @Transactional(readOnly = true)
    public Reading findOne(String vin) {
        Reading existing = readingRepository.findOne(vin);
        if (existing == null) {
            throw new ResourceNotFoundException("Readings with vin " + vin + " doesn't exist.");
        }
        return existing;
    }

    @Transactional
    public Reading create(Reading reading) {

        Vehicle vehi = repository.findOne(reading.getVin());
        if(vehi==null){
            throw new NullPointerException();
        }
        reading.setVe(vehi);

       readingRepository.create(reading);
       alertsService.checkinAlerts(reading);
       return reading;

    }

   @Transactional
    public Reading update(Reading reading) {
       return readingRepository.update(reading);
    }

    @Transactional
    public void delete(String vin) {
        Reading existing = readingRepository.findOne(vin);
        if (existing == null) {
            throw new ResourceNotFoundException("Readings with vin " + vin + " doesn't exist.");
        }
        readingRepository.delete(existing);

    }
}
