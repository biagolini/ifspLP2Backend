package br.edu.ifsp.spo.clientdataprocessor.dto.enumeration;

import br.edu.ifsp.spo.clientdataprocessor.entity.enumeration.TypeState;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TypeStateDto {

    private Long id;
    private String abbreviation;
    private String description;

    public TypeStateDto(TypeState typeState) {
        this.id = typeState.getId();
        this.abbreviation = typeState.getAbbreviation();
        this.description = typeState.getDescription();
    }
}
