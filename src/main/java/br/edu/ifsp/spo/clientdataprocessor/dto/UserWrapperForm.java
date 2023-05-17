package br.edu.ifsp.spo.clientdataprocessor.dto;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserWrapperForm {
    private List<UserForm> users;
}
