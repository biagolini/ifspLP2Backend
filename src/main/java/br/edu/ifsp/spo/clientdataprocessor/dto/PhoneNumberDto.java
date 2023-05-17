package br.edu.ifsp.spo.clientdataprocessor.dto;

import br.edu.ifsp.spo.clientdataprocessor.entity.PhoneNumber;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PhoneNumberDto {
    private Long id;
    private Long userId;
    private String userFirstName;
    private String userLastName;
    private String useremail;
    private String phoneNumber;
    private Long idPhoneNumberType;

    public PhoneNumberDto(PhoneNumber phoneNumber) {
        this.id = phoneNumber.getId();
        this.userId = phoneNumber.getUser().getId();
        this.userFirstName = phoneNumber.getUser().getFirstName();
        this.userLastName = phoneNumber.getUser().getLastName();
        this.useremail = phoneNumber.getUser().getEmail();
        this.phoneNumber = phoneNumber.getPhoneNumber();
        this.idPhoneNumberType = phoneNumber.getIdPhoneNumberType();
    }



}
