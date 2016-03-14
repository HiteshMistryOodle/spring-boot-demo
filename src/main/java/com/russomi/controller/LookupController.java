package com.russomi.controller;


import com.google.common.base.Stopwatch;
import com.russomi.domain.LookupObject;
import com.russomi.service.LookupRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class LookupController {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(LookupController.class);


    @Autowired
    private LookupRepository simpleLookupRepository;


    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }


    @RequestMapping(value = "/lookup/{name}", method = RequestMethod.GET)
    public LookupObject getLookupObjectByName(@PathVariable String name) {
        Stopwatch stopwatch = Stopwatch.createStarted();
        LookupObject lookupObject = simpleLookupRepository.getByName(name);
        stopwatch.stop();
        long millis = stopwatch.elapsed(TimeUnit.MILLISECONDS);
        logger.info("getLookupObjectByName({}) took {} ms", name, millis);
        return lookupObject;
    }
}