package io.egen.controller;

import io.egen.entity.Alert;
import io.egen.entity.Geo;
import io.egen.entity.Vehicle;

import io.egen.service.AlertsService;
import io.egen.service.GeoService;
import io.egen.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/vehicles")
public class VehicleController {

@Autowired
    VehicleService service;

@Autowired
    AlertsService alertsService;

@Autowired
    GeoService geoService;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Vehicle> findAll() {
        return service.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{vin}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Vehicle findOne(@PathVariable("vin") String vehvin) {
        return service.findOne(vehvin);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Vehicle create(@RequestBody Vehicle vehicle) {
        return service.create(vehicle);
    }

    @RequestMapping(method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.TEXT_HTML_VALUE)
    public String update(@RequestBody List<Vehicle> vehvin) {
        for(Vehicle veh: vehvin)
            service.update(veh);
        return " ";
    }
    @RequestMapping(method = RequestMethod.GET, value = "/alerts",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Alert> findAlerts() {
        System.out.println("Displaying a single vehicle by its vin number");
        return alertsService.findAlerts();
    }


    @RequestMapping(method = RequestMethod.GET, value = "/alerts/{vin}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Alert> findByVin(@PathVariable("vin") String vin) {
        System.out.println("Displaying a single vehicle by its vin number");
        return alertsService.findByVin(vin);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/geo",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Geo> getGeo() {
        System.out.println("Displaying a single vehicle by its vin number");
        return geoService.getGeo();
    }


    @RequestMapping(method = RequestMethod.GET, value = "/geo/{vin}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Geo> getGeoByVin(@PathVariable("vin") String vehId) {
        System.out.println("Displaying a single vehicle by its vin number");
        return geoService.getGeoByVin(vehId);
    }



    @RequestMapping(method = RequestMethod.DELETE, value = "/{vin}")
    public void delete(@PathVariable("vin") String vehvin) {
    service.delete(vehvin);
    }
}