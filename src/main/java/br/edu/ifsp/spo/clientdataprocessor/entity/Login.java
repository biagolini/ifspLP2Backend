package br.edu.ifsp.spo.clientdataprocessor.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tblLogin")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idLogin")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private User user;

    @Column(name = "idTypeLogin")
    private Long idTypeLogin;

    @Column(name = "dsUsername")
    private String username;

    @Column(name = "dsPassword")
    private String password;

    @Column(name = "dsPasswordDateTimeLastEdition")
    private LocalDateTime passwordDateTimeLastEdition;

    @Column(name = "stActive")
    private Boolean isActive;

}
