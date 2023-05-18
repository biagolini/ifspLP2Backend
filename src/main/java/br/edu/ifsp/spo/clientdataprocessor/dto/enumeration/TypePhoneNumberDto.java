package br.edu.ifsp.spo.clientdataprocessor.dto.enumeration;

import br.edu.ifsp.spo.clientdataprocessor.entity.enumeration.TypePhoneNumber;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TypePhoneNumberDto {
    private Long id;
    private String description;

    public TypePhoneNumberDto(TypePhoneNumber typePhoneNumber) {
        this.id = typePhoneNumber.getId();
        this.description = typePhoneNumber.getDescription();
    }
}
