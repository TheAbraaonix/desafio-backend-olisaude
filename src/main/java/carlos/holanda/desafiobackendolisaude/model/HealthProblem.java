package carlos.holanda.desafiobackendolisaude.model;

import carlos.holanda.desafiobackendolisaude.enums.Degree;
import jakarta.persistence.*;

@Entity
@Table(name = "health_problems")
public class HealthProblem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Degree degree;

    public HealthProblem() {
    }

    public HealthProblem(Long id, String name, Degree degree) {
        this.id = id;
        this.name = name;
        this.degree = degree;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }
}
