package io.egen.service;


import io.egen.entity.Vehicle;
import io.egen.exception.BadRequestException;
import io.egen.exception.ResourceNotFoundException;
import io.egen.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService{

    @Autowired
    VehicleRepository repository;

    @Transactional(readOnly = true)
    public List<Vehicle> findAll() {
        return repository.findAll();
    }
    @Transactional(readOnly = true)
    public Vehicle findOne(String vin) {
       Vehicle existing = repository.findOne(vin);
        if (existing == null) {
            throw new ResourceNotFoundException("Vehicle with vin " + vin + " doesn't exist.");
        }
        return existing;
    }
    @Transactional
    public Vehicle create(Vehicle vehicle) {
        Vehicle existing = repository.findByModel(vehicle.getModel());
        if (existing != null) {
            throw new BadRequestException("Vehicle with model " + vehicle.getModel() + " already exists.");
        }
        return repository.create(vehicle);
    }
    @Transactional
    public Vehicle update(Vehicle vehicle) {

        Vehicle existing = repository.findOne(vehicle.getVin());
        if (existing == null) {
            System.out.println(vehicle.getVin()+"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            return repository.create(vehicle);
        }
        return repository.update(vehicle);
    }
    @Transactional
    public void delete(String vin) {
        Vehicle existing = repository.findOne(vin);
        if (existing == null) {
            throw new ResourceNotFoundException("Vehicle with vin " + vin + " doesn't exist.");
        }
       repository.delete(existing);

    }
	
}
