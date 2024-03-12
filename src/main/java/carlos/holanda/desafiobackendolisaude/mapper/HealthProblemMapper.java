package carlos.holanda.desafiobackendolisaude.mapper;

import carlos.holanda.desafiobackendolisaude.dto.HealthProblemDTO;
import carlos.holanda.desafiobackendolisaude.model.HealthProblem;
import org.springframework.stereotype.Component;

@Component
public class HealthProblemMapper {
    public static HealthProblemDTO toDTO(HealthProblem healthProblem) {
        if (healthProblem == null) {
            return null;
        }

        return new HealthProblemDTO(healthProblem.getId(), healthProblem.getName(), healthProblem.getDegree());
    }
}
