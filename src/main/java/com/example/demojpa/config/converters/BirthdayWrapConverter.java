package com.example.demojpa.config.converters;

import com.example.demojpa.repos.domain.BirthdayWrap;
import jakarta.persistence.AttributeConverter;

import java.sql.Date;
import java.util.Optional;

public class BirthdayWrapConverter implements AttributeConverter<BirthdayWrap, Date> {

    @Override
    public Date convertToDatabaseColumn(BirthdayWrap birthdayWrap) {
        return Optional.ofNullable(birthdayWrap)
                .map(BirthdayWrap::getDate)
                .map(Date::valueOf)
                .orElse(null);
    }

    @Override
    public BirthdayWrap convertToEntityAttribute(Date date) {
        return Optional.ofNullable(date)
                .map(Date::toLocalDate)
                .map(BirthdayWrap::new)
                .orElse(null);
    }
}
