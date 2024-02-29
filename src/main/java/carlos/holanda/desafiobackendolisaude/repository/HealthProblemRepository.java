package carlos.holanda.desafiobackendolisaude.repository;

import carlos.holanda.desafiobackendolisaude.model.HealthProblem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HealthProblemRepository extends JpaRepository<HealthProblem, Long> {
}
