package javeriana.service.calculator.service;

import javeriana.service.calculator.repository.CalculatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javeriana.service.calculator.model.Operation;

import java.util.List;

@Service
public class CalculatorService {
    @Autowired
    CalculatorRepository repository;

    public List<Operation> findAllOperations() {
        return (List<Operation>) repository.findAll();
    }

    public List<Operation> findOperationsByUser(String user) {
        return repository.findByUser(user);
    }

    public List<Operation> findOperationsByMethod(String method) {
        return repository.findByMethod(method);
    }

    public Operation saveOperation(int a, int b, int result, String user, String method) {
        Operation operation = Operation.builder()
                .user(user)
                .method(method)
                .a(a)
                .b(b)
                .result(result)
                .build();
        return repository.save(operation);
    }
}
