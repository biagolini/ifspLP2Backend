package br.edu.ifsp.spo.clientdataprocessor.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UserWrapperForm {
    private List<UserForm> users;
}
