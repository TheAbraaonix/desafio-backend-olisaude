package carlos.holanda.desafiobackendolisaude.dto;

import carlos.holanda.desafiobackendolisaude.enums.Gender;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public record CustomerRequest(

        @NotNull @NotBlank String name,
        @NotNull @JsonFormat(pattern = "dd/MM/yyyy") LocalDate birthDate,
        @NotNull Gender gender,
        @NotEmpty List<HealthProblemDTO> healthProblems
) {
}
