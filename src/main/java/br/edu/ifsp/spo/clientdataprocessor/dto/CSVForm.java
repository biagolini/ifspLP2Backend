package br.edu.ifsp.spo.clientdataprocessor.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.TimeZone;

@Getter
@Setter
@NoArgsConstructor
public class CSVForm {
    private String gender;
    private String nameTitle;
    private String nameFirst;
    private String nameLast;
    private String locationStreet;
    private String locationCity;
    private String locationState;
    private String locationPostcode;
    private String locationCoordinatesLatitude;
    private String locationCoordinatesLongitude;
    private String locationTimezoneOffset;
    private String locationTimezoneDescription;
    private String email;
    private String dobDate;
    private String dobAge;
    private String registeredDate;
    private String registeredAge;
    private String phone;
    private String cell;
    private String pictureLarge;
    private String pictureMedium;
    private String pictureThumbnail;

}
