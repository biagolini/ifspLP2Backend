package br.edu.ifsp.spo.clientdataprocessor.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class UserForm {
    private Long idTypeGender;
    private String title;
    private String firstName;
    private String lastName;
    private Long idLocationType;
    private Long idRegionType;
    private String street;
    private String city;
    private Long idTypeState;
    private String postcode;
    private Double latitude;
    private Double longitude;
    private Long idTypeTimezone;
    private String email;
    private LocalDateTime birthday;
    private LocalDateTime registered;
    private Long idTypeNationality;
    private Boolean isActive;
}


