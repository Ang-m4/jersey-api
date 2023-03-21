package javeriana.service.calculator.controller;

import javeriana.service.calculator.model.Operation;
import javeriana.service.calculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("calculator")
public class CalculatorController {
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    CalculatorService service;

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @GetMapping
    public ResponseEntity<List<Operation>> findAllOperations() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAllOperations());
    }

    @GetMapping("/users/{user}")
    public ResponseEntity<List<Operation>> findOperationByUser(@PathVariable String user) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findOperationsByUser(user));
    }

    @GetMapping("add")
    public ResponseEntity<List<Operation>> findAllAddOperations() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findOperationsByMethod("add"));
    }

    @GetMapping("add/values")
    public int add(@RequestParam int a, @RequestParam int b, @RequestParam String user) {
        int result = restTemplate.getForObject("http://add/add?a={a}&b={b}", int.class, a, b);
        service.saveOperation(
                a,
                b,
                result,
                user,
                "add"
        );
        return result;
    }

    @GetMapping("subtract")
    public ResponseEntity<List<Operation>> findAllSubtractOperations() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findOperationsByMethod("subtract"));
    }

    @GetMapping("subtract/values")
    public int subtract(@RequestParam int a, @RequestParam int b, @RequestParam String user) {
        int result = restTemplate.getForObject("http://subtract/subtract?a={a}&b={b}", int.class, a, b);
        service.saveOperation(
                a,
                b,
                result,
                user,
                "subtract"
        );
        return result;
    }

    @GetMapping("multiply")
    public ResponseEntity<List<Operation>> findAllMultiplyOperations() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findOperationsByMethod("multiply"));
    }

    @GetMapping("multiply/values")
    public int multiply(@RequestParam int a, @RequestParam int b, @RequestParam String user) {
        int result = restTemplate.getForObject("http://multiply/multiply?a={a}&b={b}", int.class, a, b);
        service.saveOperation(
                a,
                b,
                result,
                user,
                "multiply"
        );
        return result;
    }

    @GetMapping("divide")
    public ResponseEntity<List<Operation>> findAllDivideOperations() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findOperationsByMethod("divide"));
    }

    @GetMapping("divide/values")
    public int divide(@RequestParam int a, @RequestParam int b, @RequestParam String user) {
        int result = restTemplate.getForObject("http://divide/divide?a={a}&b={b}", int.class, a, b);
        service.saveOperation(
                a,
                b,
                result,
                user,
                "divide"
        );
        return result;
    }
}
