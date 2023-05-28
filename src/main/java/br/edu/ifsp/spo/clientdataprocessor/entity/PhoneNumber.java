package br.edu.ifsp.spo.clientdataprocessor.entity;

import br.edu.ifsp.spo.clientdataprocessor.dto.PhoneNumberForm;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "tblPhoneNumber")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PhoneNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPhoneNumber")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private User user;

    @Column(name = "dsPhoneNumber")
    private String phoneNumber;

    @Column(name = "idPhoneNumberType")
    private Long idPhoneNumberType;

    @Column(name = "idPhoneNumberNationality")
    private Long idPhoneNumberNationality;

    @Column(name = "stActive")
    private Boolean isActive;

    public PhoneNumber(User user, PhoneNumberForm form) {
        this.user = user;
        this.phoneNumber = form.getPhoneNumber();
        this.idPhoneNumberType = form.getIdPhoneNumberType();
        this.isActive = true;
    }

    public PhoneNumber(User user, String phoneNumber, Long idPhoneNumberType, Long idPhoneNumberNationality) {
        this.user = user;
        this.phoneNumber = phoneNumber;
        this.idPhoneNumberType = idPhoneNumberType;
        this.idPhoneNumberNationality = idPhoneNumberNationality;
        this.isActive = true;
    }


    public void update(User user, PhoneNumberForm form) {
        this.user = user;
        this.phoneNumber = form.getPhoneNumber();
        this.idPhoneNumberType = form.getIdPhoneNumberType();
        this.idPhoneNumberNationality = form.getIdPhoneNumberType();
    }

}
