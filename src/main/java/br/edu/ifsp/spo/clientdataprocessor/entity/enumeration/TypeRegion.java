package br.edu.ifsp.spo.clientdataprocessor.entity.enumeration;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tblTypeRegion")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TypeRegion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRegionType")
    private Long id;

    @Column(name = "dsType")
    private String description;

    @Column(name = "stActive")
    private Boolean isActive;
}
