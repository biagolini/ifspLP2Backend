package br.edu.ifsp.spo.clientdataprocessor.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PhoneNumberForm {
    private Long userId;
    private String phoneNumber;
    private Long idPhoneNumberType;

}
