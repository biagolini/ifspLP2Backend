package br.edu.ifsp.spo.clientdataprocessor.entity;

import br.edu.ifsp.spo.clientdataprocessor.dto.UserForm;
import br.edu.ifsp.spo.clientdataprocessor.entity.enumeration.TypeState;
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

    @Column(name = "dsStreet")
    private String street;

    @Column(name = "dsCity")
    private String city;

    @ManyToOne
    @JoinColumn(name = "idTypeState")
    private TypeState typeState;

    @Column(name = "dsPostcode")
    private String postcode;

    @Column(name = "dsLatitude")
    private Double latitude;

    @Column(name = "dsLongitude")
    private Double longitude;

    @Column(name = "idLocationType")
    private Long idLocationType;

    @Column(name = "idTypeTimezone")
    private Long idTypeTimezone;

    @Column(name = "dsEmail")
    private String email;

    @Column(name = "dtBirthday")
    private LocalDateTime birthday;

    @Column(name = "dtRegistered")
    private LocalDateTime registered;

    @Column(name = "stActive")
    private Boolean isActive;

    public User(UserForm form, TypeState TypeState) {
        this.idTypeGender = form.getIdTypeGender();
        this.title = form.getTitle();
        this.firstName = form.getFirstName();
        this.lastName = form.getLastName();
        this.idLocationType = form.getIdLocationType();
        this.street = form.getStreet();
        this.city = form.getCity();
        this.typeState = TypeState;
        this.postcode = form.getPostcode();
        this.latitude = form.getLatitude();
        this.longitude = form.getLongitude();
        this.idTypeTimezone = form.getIdTypeTimezone();
        this.email = form.getEmail();
        this.birthday = form.getBirthday();
        this.registered = LocalDateTime.now();
        this.isActive = true;
    }

    public void update(UserForm form, TypeState TypeState) {
        this.idTypeGender = form.getIdTypeGender();
        this.title = form.getTitle();
        this.firstName = form.getFirstName();
        this.lastName = form.getLastName();
        this.idLocationType = form.getIdLocationType();
        this.street = form.getStreet();
        this.city = form.getCity();
        this.typeState = TypeState;
        this.postcode = form.getPostcode();
        this.latitude = form.getLatitude();
        this.longitude = form.getLongitude();
        this.idTypeTimezone = form.getIdTypeTimezone();
        this.email = form.getEmail();
        this.birthday = form.getBirthday();
    }

    public User(Long idTypeGender, String title, String firstName, String lastName, Long idLocationType, String street, String city, TypeState TypeState, String postcode, Double latitude, Double longitude, Long idTypeTimezone, String email, LocalDateTime birthday, LocalDateTime registered) {
        this.idTypeGender = idTypeGender;
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.idLocationType = idLocationType;
        this.street = street;
        this.city = city;
        this.typeState = TypeState;
        this.postcode = postcode;
        this.latitude = latitude;
        this.longitude = longitude;
        this.idTypeTimezone = idTypeTimezone;
        this.email = email;
        this.birthday = birthday;
        this.registered = registered;
        this.isActive = true;
    }

}
