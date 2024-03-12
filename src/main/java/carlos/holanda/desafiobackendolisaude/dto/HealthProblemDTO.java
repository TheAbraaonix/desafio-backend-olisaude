package carlos.holanda.desafiobackendolisaude.dto;

import carlos.holanda.desafiobackendolisaude.enums.Degree;

public record HealthProblemDTO(

        Long id,
        String name,
        Degree degree
) {
}
