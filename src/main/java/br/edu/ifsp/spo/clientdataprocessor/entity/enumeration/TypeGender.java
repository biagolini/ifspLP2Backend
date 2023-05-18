package br.edu.ifsp.spo.clientdataprocessor.entity.enumeration;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tblTypeGender")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TypeGender {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTypeGender")
    private Long id;

    @Column(name = "dsType")
    private String description;

    @Column(name = "stActive")
    private Boolean isActive;

}
