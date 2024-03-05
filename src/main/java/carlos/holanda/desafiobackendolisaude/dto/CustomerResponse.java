package carlos.holanda.desafiobackendolisaude.dto;

import carlos.holanda.desafiobackendolisaude.model.Gender;

import java.time.LocalDateTime;

public record CustomerResponse(
        Long id,
        String name,
        Gender gender,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
