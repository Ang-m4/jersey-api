package javeriana.service.calculator.repository;

import javeriana.service.calculator.model.Operation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CalculatorRepository extends CrudRepository<Operation, Integer> {
    @Query(value = "SELECT * FROM operations o WHERE o.username = ?1", nativeQuery = true)
    List<Operation> findByUser(String user);

    @Query(value = "SELECT * FROM operations o WHERE o.method = ?1", nativeQuery = true)
    List<Operation> findByMethod(String method);
}
