package com.serenitydojo;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.AbstractBigDecimalAssert;

import java.time.LocalDate;
import java.time.Month;

public class DateAssertions extends AbstractAssert<DateAssertions, LocalDate> {

    public DateAssertions(LocalDate localDate) {
        super(localDate, DateAssertions.class);
    }


    public static DateAssertions assertThat(LocalDate actual) {
        return new DateAssertions(actual);
    }

    public DateAssertions isEqualTo(int expectedDay, Month expectedMonth, int expectedYear) {
        if (actual.getYear() != expectedYear || actual.getMonth() != expectedMonth || actual.getDayOfMonth() != expectedDay) {
            failWithMessage("Expected a date of %s %s %s but was %s", expectedDay, expectedMonth, expectedYear,actual);
        }
        return this;
    }
}
