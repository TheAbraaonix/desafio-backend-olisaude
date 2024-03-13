package carlos.holanda.desafiobackendolisaude.dto;

import carlos.holanda.desafiobackendolisaude.enums.Degree;

public record HealthProblemDTO(

        String name,
        Degree degree
) {
}
