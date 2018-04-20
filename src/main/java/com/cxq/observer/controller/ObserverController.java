package com.cxq.observer.controller;

import com.cxq.observer.service.ObserverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "observer")
public class ObserverController {

    @Autowired
    private ObserverService observerService;

    @RequestMapping(value = "/test")
    public String observerEvent(@RequestParam(value = "data") String data) {
        return observerService.observerEvent(data);
    }
}
