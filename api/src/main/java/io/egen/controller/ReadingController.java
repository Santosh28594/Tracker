package io.egen.controller;


import io.egen.entity.Reading;

import io.egen.service.ReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/readings")
public class ReadingController {
    @Autowired
    ReadingService readingService;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Reading> findAll() {
        return readingService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{vin}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Reading findOne(@PathVariable("vin") String readvin) {
        return readingService.findOne(readvin);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.TEXT_HTML_VALUE)
    public String create( @RequestBody Reading read) {

        readingService.create(read);
        return "";
    }

    @RequestMapping(method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.TEXT_HTML_VALUE)
    public String update(@RequestBody List<Reading> readvin) {
        for(Reading read: readvin)
            readingService.update(read);
        return " ";
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{vin}")
    public void delete(@PathVariable("vin") String readvin) {
        readingService.delete(readvin);
    }
}
