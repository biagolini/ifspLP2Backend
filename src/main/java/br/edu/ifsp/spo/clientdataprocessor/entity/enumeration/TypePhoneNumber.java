package br.edu.ifsp.spo.clientdataprocessor.entity.enumeration;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tblTypePhoneNumber")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TypePhoneNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPhoneNumberType")
    private Long id;

    @Column(name = "dsType")
    private String description;

    @Column(name = "stActive")
    private Boolean isActive;

}
