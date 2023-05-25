package br.edu.ifsp.spo.clientdataprocessor.entity.enumeration;
import br.edu.ifsp.spo.clientdataprocessor.entity.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tblTypeState")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TypeState {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTypeState")
    private Long id;

    @Column(name = "dsAbbreviation")
    private String abbreviation;

    @Column(name = "dsType")
    private String description;

    @Column(name = "idRegionType")
    private Long idRegionType;

    @Column(name = "stActive")
    private Boolean isActive;


}
