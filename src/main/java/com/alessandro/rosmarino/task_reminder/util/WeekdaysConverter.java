package com.alessandro.rosmarino.task_reminder.util;

import jakarta.persistence.AttributeConverter;

public class WeekdaysConverter implements AttributeConverter<String[], String> {
    @Override
    public String convertToDatabaseColumn(String[] strings) {
        return String.join(",", strings);
    }

    @Override
    public String[] convertToEntityAttribute(String s) {
        return s.split(",");
    }
}
