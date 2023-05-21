package br.edu.ifsp.spo.clientdataprocessor.entity;

import br.edu.ifsp.spo.clientdataprocessor.dto.UserForm;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "tblUser")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUser")
    private Long id;

    @Column(name =  "idTypeGender")
    private Long idTypeGender;

    @Column(name = "dsTitle")
    private String title;

    @Column(name = "dsFirstName")
    private String firstName;

    @Column(name = "dsLastName")
    private String lastName;

    @Column(name = "idLocationType")
    private Long idLocationType;

    @Column(name = "idRegionType")
    private Long idRegionType;

    @Column(name = "dsStreet")
    private String street;

    @Column(name = "dsCity")
    private String city;

    @Column(name = "idTypeState")
    private Long idTypeState;

    @Column(name = "dsPostcode")
    private String postcode;

    @Column(name = "dsLatitude")
    private Double latitude;

    @Column(name = "dsLongitude")
    private Double longitude;

    @Column(name = "idTypeTimezone")
    private Long idTypeTimezone;

    @Column(name = "dsEmail")
    private String email;

    @Column(name = "dtBirthday")
    private LocalDateTime birthday;

    @Column(name = "dtRegistered")
    private LocalDateTime registered;

    @Column(name ="idTypeNationality")
    private Long idTypeNationality;

    @Column(name = "stActive")
    private Boolean isActive;

    public User(UserForm form) {
        this.idTypeGender = form.getIdTypeGender();
        this.title = form.getTitle();
        this.firstName = form.getFirstName();
        this.lastName = form.getLastName();
        this.idLocationType = form.getIdLocationType();
        this.idRegionType = form.getIdRegionType();
        this.street = form.getStreet();
        this.city = form.getCity();
        this.idTypeState = form.getIdTypeState();
        this.postcode = form.getPostcode();
        this.latitude = form.getLatitude();
        this.longitude = form.getLongitude();
        this.idTypeTimezone = form.getIdTypeTimezone();
        this.email = form.getEmail();
        this.birthday = form.getBirthday();
        this.registered = LocalDateTime.now();
        this.idTypeNationality = form.getIdTypeNationality();
        this.isActive = true;
    }


    public void update(UserForm form) {
        this.idTypeGender = form.getIdTypeGender();
        this.title = form.getTitle();
        this.firstName = form.getFirstName();
        this.lastName = form.getLastName();
        this.idLocationType = form.getIdLocationType();
        this.idRegionType = form.getIdRegionType();
        this.street = form.getStreet();
        this.city = form.getCity();
        this.idTypeState = form.getIdTypeState();
        this.postcode = form.getPostcode();
        this.latitude = form.getLatitude();
        this.longitude = form.getLongitude();
        this.idTypeTimezone = form.getIdTypeTimezone();
        this.email = form.getEmail();
        this.birthday = form.getBirthday();
        this.idTypeNationality = form.getIdTypeNationality();
    }

}
