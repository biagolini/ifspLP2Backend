package br.edu.ifsp.spo.clientdataprocessor.dto;

import br.edu.ifsp.spo.clientdataprocessor.utils.ReadLocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.csv.CSVRecord;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeParseException;

@Getter
@Setter
@NoArgsConstructor
public class WrapperForm {
    public String gender;
    public Name name;
    public Location location;
    public String email;
    public Dob dob;
    public Registered registered;
    public String phone;
    public String cell;
    public Picture picture;


    @Setter
    @NoArgsConstructor
    public static class Name {
        public String title;
        public String first;
        public String last;

        public Name(CSVRecord record) {
            this.title = record.get("name.title");
            this.first = record.get("name.first");
            this.last = record.get("name.last");
        }
    }

    @Setter
    @NoArgsConstructor
    public static class Location {
        public String street;
        public String city;
        public String state;
        public String postcode;
        public Coordinates coordinates;
        public Timezone timezone;

        public Location(CSVRecord record) {
            this.street = record.get("location.street");
            this.city = record.get("location.city");
            this.state = record.get("location.state");
            this.postcode = record.get("location.postcode");
            this.coordinates = new Coordinates(record);
            this.timezone = new Timezone(record);
        }

        @Setter
        @NoArgsConstructor
        public static class Coordinates {
            public String latitude;
            public String longitude;

            public Coordinates(CSVRecord record) {
                this.latitude = record.get("location.coordinates.latitude");
                this.longitude = record.get("location.coordinates.longitude");
            }
        }

        @Setter
        @NoArgsConstructor
        public static class Timezone {
            public String offset;
            public String description;

            public Timezone(CSVRecord record) {
                this.offset = record.get("location.timezone.offset");
                this.description = record.get("location.timezone.description");
            }
        }
    }

    @Setter
    @NoArgsConstructor
    public static class Dob {
        public LocalDateTime date;
        public int age;

        public Dob(CSVRecord record) {
            try {
                this.date = ReadLocalDateTime.fromObject(record.get("dob.date"));
                this.age = Integer.parseInt(record.get("dob.age"));
            } catch (
                    DateTimeParseException e) {
                throw new IllegalArgumentException("Invalid date format in CSV: " + record.get("dob.date"), e);
            }
        }
    }


    @Setter
    @NoArgsConstructor
    public static class Registered {
        public LocalDateTime date;
        public int age;

        public Registered(CSVRecord record) {
            try {
                this.date = ReadLocalDateTime.fromObject(record.get("Registered.date"));
                this.age = Integer.parseInt(record.get("Registered.age"));
            } catch (DateTimeParseException e) {
                throw new IllegalArgumentException("Invalid date format in CSV: " + record.get("Registered.date"), e);
            }
        }
    }


    @Setter
    @NoArgsConstructor
    public static class Picture {
        public String large;
        public String medium;
        public String thumbnail;

        public Picture(CSVRecord record) {
            this.large = record.get("picture.large");
            this.medium = record.get("picture.medium");
            this.thumbnail = record.get("picture.thumbnail");
        }
    }

    public WrapperForm(CSVRecord record) {
        this.gender = record.get("gender");
        this.name = new Name(record);
        this.location = new Location(record);
        this.email = record.get("email");
        this.dob = new Dob(record);
        this.registered = new Registered(record);
        this.phone = record.get("phone");
        this.cell = record.get("cell");
        this.picture = new Picture(record);
    }


}
