package br.edu.ifsp.spo.clientdataprocessor.entity;

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
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private User user;

    @Column(name = "dsPhoneNumber")
    private String phoneNumber;

    @Column(name = "idPhoneNumberType")
    private Long idPhoneNumberType;

    @Column(name = "stActive")
    private Boolean isActive;

}
