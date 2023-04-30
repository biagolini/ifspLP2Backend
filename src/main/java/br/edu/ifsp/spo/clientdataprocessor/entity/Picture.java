package br.edu.ifsp.spo.clientdataprocessor.entity;


import lombok.*;
import jakarta.persistence.*;


@Entity
@Table(name = "tblPicture")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPicture")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUser")
    private User user;

    @Column(name = "dsLargeUrl")
    private String largeUrl;

    @Column(name = "dsMediumUrl")
    private String mediumUrl;

    @Column(name = "dsThumbnailUrl")
    private String thumbnailUrl;

    @Column(name = "stActive")
    private Boolean isActive;
}