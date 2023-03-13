package com.javeriana.service.substract.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubstractController {
    @GetMapping("/substract")
    public int substract(@RequestParam int a, @RequestParam int b){
        return a - b;
    }
}
