package br.edu.ifsp.spo.clientdataprocessor.entity.enumeration;
import jakarta.persistence.*;
import lombok.*;

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

    @Column(name = "stActive")
    private Boolean isActive;

}
