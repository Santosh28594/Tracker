package io.egen.controller;

import io.egen.entity.AlertCount;
import io.egen.service.AlertCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/alertCount")
public class AlertCountController {


    @Autowired
    AlertCountService alertCountService;



    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<AlertCount> getAlertCount() {
        System.out.println("Displaying all the data from vehicles");
        return alertCountService.getAlertCount();
    }
}
