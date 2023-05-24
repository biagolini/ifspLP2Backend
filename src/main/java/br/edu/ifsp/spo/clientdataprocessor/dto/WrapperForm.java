package br.edu.ifsp.spo.clientdataprocessor.dto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class WrapperForm {
    public String gender;
    public WrapperForm.Name name;
    public WrapperForm.Location location;
    public String email;
    public WrapperForm.Dob dob;
    public WrapperForm.Registered registered;
    public String phone;
    public String cell;
    public WrapperForm.Picture picture;

    public static class Name {
        public String title;
        public String first;
        public String last;
    }

    public static class Location {
        public String street;
        public String city;
        public String state;
        public String postcode;
        public WrapperForm.Location.Coordinates coordinates;
        public WrapperForm.Location.Timezone timezone;

        public static class Coordinates {
            public String latitude;
            public String longitude;
        }

        public static class Timezone {
            public String offset;
            public String description;
        }
    }

    public static class Dob {
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
        public LocalDateTime date;
        public int age;
    }

    public static class Registered {
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
        public LocalDateTime date;
        public int age;
    }

    public static class Picture {
        public String large;
        public String medium;
        public String thumbnail;
    }
/*
    public static WrapperForm toWrapperForm(CSVForm csvForm) {
        WrapperForm wrapperForm = new WrapperForm();

        wrapperForm.gender = csvForm.getGender();
        wrapperForm.name = new Name();
        wrapperForm.name.title = csvForm.getNameTitle();
        wrapperForm.name.first = csvForm.getNameFirst();
        wrapperForm.name.last = csvForm.getNameLast();

        wrapperForm.location = new Location();
        wrapperForm.location.street = csvForm.getLocationStreet();
        wrapperForm.location.city = csvForm.getLocationCity();
        wrapperForm.location.state = csvForm.getLocationState();
        wrapperForm.location.postcode = csvForm.getLocationPostcode();
        wrapperForm.location.coordinates = new Location.Coordinates();
        wrapperForm.location.coordinates.latitude = csvForm.getLocationCoordinatesLatitude();
        wrapperForm.location.coordinates.longitude = csvForm.getLocationCoordinatesLongitude();
        wrapperForm.location.timezone = new Location.Timezone();
        wrapperForm.location.timezone.offset = csvForm.getLocationTimezoneOffset();
        wrapperForm.location.timezone.description = csvForm.getLocationTimezoneDescription();

        wrapperForm.email = csvForm.getEmail();

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        try {
            wrapperForm.dob = new Dob();
            wrapperForm.dob.date = format.parse(csvForm.getDobDate());
            wrapperForm.dob.age = Integer.parseInt(csvForm.getDobAge());

            wrapperForm.registered = new Registered();
            wrapperForm.registered.date = format.parse(csvForm.getRegisteredDate());
            wrapperForm.registered.age = Integer.parseInt(csvForm.getRegisteredAge());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        wrapperForm.phone = csvForm.getPhone();
        wrapperForm.cell = csvForm.getCell();

        wrapperForm.picture = new Picture();
        wrapperForm.picture.large = csvForm.getPictureLarge();
        wrapperForm.picture.medium = csvForm.getPictureMedium();
        wrapperForm.picture.thumbnail = csvForm.getPictureThumbnail();

        return wrapperForm;
    }
    */

}