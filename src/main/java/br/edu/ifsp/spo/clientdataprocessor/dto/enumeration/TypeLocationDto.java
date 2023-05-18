package br.edu.ifsp.spo.clientdataprocessor.dto.enumeration;

import br.edu.ifsp.spo.clientdataprocessor.entity.enumeration.TypeLocation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TypeLocationDto {
    private Long id;
    private String description;

    public TypeLocationDto(TypeLocation typeLocation) {
        this.id = typeLocation.getId();
        this.description = typeLocation.getDescription();
    }
}
