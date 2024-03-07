package carlos.holanda.desafiobackendolisaude.dto;

import carlos.holanda.desafiobackendolisaude.model.Gender;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record CustomerRequest(

        String name,
        @JsonFormat(pattern = "dd/MM/yyyy") LocalDate birthDate,
        Gender gender
) {
}
