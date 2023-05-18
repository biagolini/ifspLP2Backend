package br.edu.ifsp.spo.clientdataprocessor.entity.enumeration;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tblTypeTimezone")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TypeTimeZone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTypeTimezone")
    private Long id;

    @Column(name = "dsTimezoneOffset")
    private String timezoneOffset;

    @Column(name = "dsTimezoneDescription")
    private String timezoneDescription;

    @Column(name = "stActive")
    private Boolean isActive;
}
