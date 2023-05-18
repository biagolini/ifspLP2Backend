package br.edu.ifsp.spo.clientdataprocessor.dto.enumeration;

import br.edu.ifsp.spo.clientdataprocessor.entity.enumeration.TypeNationality;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TypeNationalityDto {
    private Long id;
    private String abbreviation;
    private String description;

    public TypeNationalityDto(TypeNationality typeNationality) {
        this.id = typeNationality.getId();
        this.abbreviation = typeNationality.getAbbreviation();
        this.description = typeNationality.getDescription();
    }
}
