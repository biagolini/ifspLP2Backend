package br.edu.ifsp.spo.clientdataprocessor.dto.enumeration;

import br.edu.ifsp.spo.clientdataprocessor.entity.enumeration.TypeLogin;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TypeLoginDto {
    private Long id;
    private String description;

    public TypeLoginDto(TypeLogin typeLogin) {
        this.id = typeLogin.getId();
        this.description = typeLogin.getDescription();
    }
}
