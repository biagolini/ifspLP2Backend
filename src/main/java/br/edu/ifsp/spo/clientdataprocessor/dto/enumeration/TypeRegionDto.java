package br.edu.ifsp.spo.clientdataprocessor.dto.enumeration;

import br.edu.ifsp.spo.clientdataprocessor.entity.enumeration.TypeRegion;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TypeRegionDto {
    private Long id;
    private String description;

    public TypeRegionDto(TypeRegion typeRegion) {
        this.id = typeRegion.getId();
        this.description = typeRegion.getDescription();
    }
}
