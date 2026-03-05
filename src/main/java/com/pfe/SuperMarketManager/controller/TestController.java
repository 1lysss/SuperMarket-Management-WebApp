package com.pfe.SuperMarketManager.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class TestController {


    @GetMapping("/greeting")
    public String greeting() {
        return "Hello from controller, Ilyass!";
    }

}   