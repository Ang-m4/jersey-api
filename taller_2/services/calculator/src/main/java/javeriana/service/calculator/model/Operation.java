package javeriana.service.calculator.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "operations")
public class Operation {
    @Id
    @Column(name = "id")
    @GeneratedValue()
    private int id;

    @Column(name = "username")
    private String user;

    @Column(name = "method")
    private String method;

    @Column(name = "first_value")
    private int a;

    @Column(name = "second_value")
    private int b;

    @Column(name = "result")
    private int result;
}
