package carlos.holanda.desafiobackendolisaude.dto;

import carlos.holanda.desafiobackendolisaude.enums.Gender;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record CustomerRequest(

        String name,
        @JsonFormat(pattern = "dd/MM/yyyy") LocalDate birthDate,
        Gender gender
) {
}
