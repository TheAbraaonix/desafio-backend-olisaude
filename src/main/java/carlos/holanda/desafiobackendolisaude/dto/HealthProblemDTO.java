package carlos.holanda.desafiobackendolisaude.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public record HealthProblemDTO(

        String name,
        @Min(1) @Max(2) int degree
) {
}
