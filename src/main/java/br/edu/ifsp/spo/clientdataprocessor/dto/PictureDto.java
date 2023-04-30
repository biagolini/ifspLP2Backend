package br.edu.ifsp.spo.clientdataprocessor.dto;

import br.edu.ifsp.spo.clientdataprocessor.entity.Picture;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PictureDto {
    private Long id;
    private Long userId;
    private String userFirstName;
    private String userLastName;
    private String email;
    private String largeUrl;
    private String mediumUrl;
    private String thumbnailUrl;

    public PictureDto(Picture picture) {
        this.id = picture.getId();
        this.userId = Long.valueOf(picture.getUser().getId());
        this.userFirstName = picture.getUser().getFirstName();
        this.userLastName = picture.getUser().getLastName();
        this.email = picture.getUser().getEmail();
        this.largeUrl = picture.getLargeUrl();
        this.mediumUrl = picture.getMediumUrl();
        this.thumbnailUrl = picture.getThumbnailUrl();
    }

}
