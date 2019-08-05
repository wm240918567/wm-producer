package com.wm.producer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

    @GetMapping("/get1")
    public String get1(){
        return "aaaaaaaaaaaaaaaaaaaaaa";
    }

}
