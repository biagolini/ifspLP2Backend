package br.edu.ifsp.spo.clientdataprocessor.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserWrapperDto {
    private List<UserDto> users;
}
