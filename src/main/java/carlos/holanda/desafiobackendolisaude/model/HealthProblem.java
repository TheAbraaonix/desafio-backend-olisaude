package carlos.holanda.desafiobackendolisaude.model;

import jakarta.persistence.*;

@Entity
@Table(name = "health_problems")
public class HealthProblem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Degree degree;
}
