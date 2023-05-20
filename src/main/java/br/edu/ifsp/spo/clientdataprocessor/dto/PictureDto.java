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
    private String largeUrl;
    private String mediumUrl;
    private String thumbnailUrl;

    public PictureDto(Picture picture) {
        this.id = picture.getId();
        this.userId = Long.valueOf(picture.getUser().getId());
        this.largeUrl = picture.getLargeUrl();
        this.mediumUrl = picture.getMediumUrl();
        this.thumbnailUrl = picture.getThumbnailUrl();
    }

    public void update(Picture picture) {
        this.id = picture.getId();
        this.userId = Long.valueOf(picture.getUser().getId());
        this.largeUrl = picture.getLargeUrl();
        this.mediumUrl = picture.getMediumUrl();
        this.thumbnailUrl = picture.getThumbnailUrl();
    }
}
