package carlos.holanda.desafiobackendolisaude.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "costumers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "costumer_id")
    private List<HealthProblem> healthProblems;
}
