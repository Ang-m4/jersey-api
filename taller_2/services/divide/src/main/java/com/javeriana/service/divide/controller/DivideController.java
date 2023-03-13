package com.javeriana.service.divide.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DivideController {
    @GetMapping("/divide")
    public Integer divide(@RequestParam int a, @RequestParam int b) {
        try{
            return a / b;
        }catch(Exception e){
            return null;
        }
    }
}
