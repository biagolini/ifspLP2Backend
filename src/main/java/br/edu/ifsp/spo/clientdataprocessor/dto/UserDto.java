package br.edu.ifsp.spo.clientdataprocessor.dto;

import br.edu.ifsp.spo.clientdataprocessor.entity.PhoneNumber;
import br.edu.ifsp.spo.clientdataprocessor.entity.Picture;
import br.edu.ifsp.spo.clientdataprocessor.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {
    // About user id
    private Long id;
    private Long idTypeGender;
    private String title;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDateTime birthday;
    private Long idTypeNationality;
    private Long idTypeTimezone;
    // About user location
    private String street;
    private String city;
    private Long idTypeState;
    private String postcode;
    private Long idLocationType;
    private Long idRegionType;
    private Double latitude;
    private Double longitude;
    // About our system
    private LocalDateTime registered;
    private String thumbnailUrl;

    public UserDto(User user) {
        this.id = user.getId();
        this.idTypeGender = user.getIdTypeGender();
        this.title = user.getTitle();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.idLocationType = user.getIdLocationType();
        this.idRegionType = user.getIdRegionType();
        this.street = user.getStreet();
        this.city = user.getCity();
        this.idTypeState = user.getIdTypeState();
        this.postcode = user.getPostcode();
        this.latitude = user.getLatitude();
        this.longitude = user.getLongitude();
        this.idTypeTimezone = user.getIdTypeTimezone();
        this.email = user.getEmail();
        this.birthday = user.getBirthday();
        this.registered = user.getRegistered();
        this.idTypeNationality = user.getIdTypeNationality();
    }
}
