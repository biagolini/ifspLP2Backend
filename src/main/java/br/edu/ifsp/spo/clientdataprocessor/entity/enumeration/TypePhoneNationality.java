package br.edu.ifsp.spo.clientdataprocessor.entity.enumeration;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tblTypePhoneNationality")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TypePhoneNationality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPhoneNumberNationality")
    private Long id;

    @Column(name = "dsCountryAbbreviation")
    private String countryAbbreviation;

    @Column(name = "dsCountryDescription")
    private String countryDescription;

    @Column(name = "dsCode")
    private String code;

    @Column(name = "stActive")
    private Boolean isActive;

}
