package carlos.holanda.desafiobackendolisaude.dto;

import carlos.holanda.desafiobackendolisaude.model.Gender;

import java.time.LocalDateTime;

public record CustomerRequest(

        String name,
        Gender gender
) {
}
