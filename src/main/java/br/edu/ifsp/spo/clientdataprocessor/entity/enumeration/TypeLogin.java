package br.edu.ifsp.spo.clientdataprocessor.entity.enumeration;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tblTypeLogin")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TypeLogin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idLocationType")
    private Long id;

    @Column(name = "dsType")
    private String description;

    @Column(name = "stActive")
    private Boolean isActive;
}
