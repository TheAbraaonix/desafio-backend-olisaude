package carlos.holanda.desafiobackendolisaude.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "health_problems")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HealthProblem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Degree degree;
}
