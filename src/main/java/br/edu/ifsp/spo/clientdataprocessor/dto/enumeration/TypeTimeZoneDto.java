package br.edu.ifsp.spo.clientdataprocessor.dto.enumeration;

import br.edu.ifsp.spo.clientdataprocessor.entity.enumeration.TypeTimeZone;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TypeTimeZoneDto {

    private Long id;
    private String timezoneOffset;
    private String timezoneDescription;

    public TypeTimeZoneDto(TypeTimeZone typeTimeZone) {
        this.id = typeTimeZone.getId();
        this.timezoneOffset = typeTimeZone.getTimezoneOffset();
        this.timezoneDescription = typeTimeZone.getTimezoneDescription();
    }
}
