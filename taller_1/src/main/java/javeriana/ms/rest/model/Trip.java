package javeriana.ms.rest.model;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@XmlRootElement
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Trip {
    private int id;
    private String name;
    private String source;
    private String destination;
    private LocalDate startDate;
    private LocalDate endDate;
}
