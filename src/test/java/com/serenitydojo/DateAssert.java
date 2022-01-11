package com.serenitydojo;

import org.assertj.core.api.AbstractAssert;

import java.time.LocalDate;
import java.time.Month;

public class DateAssert extends AbstractAssert<DateAssert, LocalDate> {

    public DateAssert(LocalDate actual) {
        super(actual, DateAssert.class);
    }

    public static DateAssert assertThat(LocalDate actual) {
        return new DateAssert(actual);
    }

    public DateAssert isEqualTo(int expectedYear, Month expectedMonth, int expectedDay) {
        if (actual.getYear() != expectedYear
                || actual.getMonth() != expectedMonth
                || actual.getDayOfMonth() != expectedDay) {
            failWithMessage("Expected a date of %s %s %s but was %s", expectedDay, expectedMonth, expectedYear, actual);
        }
        return this;
    }
}

