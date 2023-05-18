package br.edu.ifsp.spo.clientdataprocessor.dto.enumeration;

import br.edu.ifsp.spo.clientdataprocessor.entity.enumeration.TypeGender;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TypeGenderDto {
    private Long id;
    private String description;

    public TypeGenderDto(TypeGender typeGender) {
        this.id = typeGender.getId();
        this.description = typeGender.getDescription();
    }
}
