package br.edu.ifsp.spo.clientdataprocessor.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ReadLocalDateTime {

    public static LocalDateTime fromObject(Object object) throws DateTimeParseException {
        if (object instanceof LocalDateTime) {
            return (LocalDateTime) object;
        }

        if (object instanceof Instant) {
            return LocalDateTime.ofInstant((Instant) object, ZoneId.systemDefault());
        }

        if (object instanceof String) {
            try {
                return LocalDateTime.parse((String) object, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
            } catch (DateTimeParseException e) {
                return LocalDateTime.parse((String) object, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
            }
        }

        throw new DateTimeParseException("Could not parse date: unrecognized format", "", 0);
    }
}
