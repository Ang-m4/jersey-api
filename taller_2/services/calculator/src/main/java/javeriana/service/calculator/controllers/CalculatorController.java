package javeriana.service.calculator.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CalculatorController {
    @Autowired
    RestTemplate restTemplate;

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @GetMapping("calculator/add")
    public int add(@RequestParam int a, @RequestParam int b) {
        return restTemplate.getForObject("http://add/add?a={a}&b={b}", int.class, a, b);
    }

    @GetMapping("calculator/substract")
    public int substract(@RequestParam int a, @RequestParam int b) {
        return restTemplate.getForObject("http://substract/subsctract?a={a}&b={b}", int.class, a, b);
    }

    @GetMapping("calculator/multiply")
    public int multiply(@RequestParam int a, @RequestParam int b) {
        return restTemplate.getForObject("http://multiply/multiply?a={a}&b={b}", int.class, a, b);
    }

    @GetMapping("calculator/divide")
    public int divide(@RequestParam int a, @RequestParam int b) {
        return restTemplate.getForObject("http://divide/divide?a={a}&b={b}", int.class, a, b);
    }
}
