package com.serenitydojo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

import static com.serenitydojo.DateAssert.assertThat;

@DisplayName("When working with dates in Java 8")
class WhenWorkingWithDates {

    @DisplayName("The LocalDate class represents a date")
    @Nested
    class CreatingLocalDates {

        @Test
        @DisplayName("We can create a date by specifying the year, month and day")
        void creatingASimpleDate() {
            LocalDate jan26 = LocalDate.of(2022, 1, 26);

            assertThat(jan26).isEqualTo(2022, Month.JANUARY, 26);
        }

        @Test
        @DisplayName("We can create a date by using a string")
        void creatingASimpleDateFromAString() {
            LocalDate jan26 = LocalDate.parse("2022-01-26");

            assertThat(jan26).isEqualTo(2022, Month.JANUARY, 26);
        }

        @Test
        @DisplayName("We can create a date by using a formatted string")
        void createADateFromAFormattedString() {
            LocalDate jan26 = LocalDate.parse("26/01/2022", DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            assertThat(jan26).isEqualTo(2022, Month.JANUARY, 26);
        }
    }

    @DisplayName("We can use LocalDates to find relative dates")
    @Nested
    class CreatingRelativeDates {
        @Test
        @DisplayName("We can create a date for the following day")
        void findTheNextDay() {
            LocalDate jan26 = LocalDate.of(2022, 1, 26);
            LocalDate jan27 = jan26.plusDays(1);
            assertThat(jan27).isEqualTo(2022, Month.JANUARY, 27);
        }

        @Test
        @DisplayName("We can create a date for the following month")
        void findTheNextMonth() {
            LocalDate jan26 = LocalDate.of(2022, 1, 26);
            LocalDate feb26 = jan26.plusMonths(1);
            assertThat(feb26).isEqualTo(2022, Month.FEBRUARY, 26);
            // Challenge: see what happens when you add 1 month to Jan 30th
        }

        @Test
        @DisplayName("We can find a specific day of the week")
        void findTheNextMonday() {
            LocalDate jan26 = LocalDate.of(2022, 1, 26);
            LocalDate followingMonday = findFollowingWeekDay(jan26, DayOfWeek.MONDAY);

            assertThat(followingMonday).isEqualTo(2022, Month.JANUARY, 31);
        }

        @Test
        @DisplayName("We can find a specific day of the week using temporal adjusters")
        void usingTemporalAdjusters() {
            LocalDate jan26 = LocalDate.of(2022, 1, 26);
            LocalDate nextMonday  = jan26.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
            assertThat(nextMonday).isEqualTo(2022, Month.JANUARY, 31);
        }

        @Test
        @DisplayName("We can find a specific day of the week using temporal adjusters")
        void usingTemporalAdjustersToGetTheNextOrCurrentDate() {
            LocalDate jan24 = LocalDate.of(2022, 1, 24);
            LocalDate nextMonday  = jan24.with(TemporalAdjusters.nextOrSame(DayOfWeek.MONDAY));
            assertThat(nextMonday).isEqualTo(2022, Month.JANUARY, 24);
        }

        @Test
        @DisplayName("We can find the first day of the next month")
        void usingOtherTemporalAdjusters() {
            LocalDate jan26 = LocalDate.of(2022, 1, 26);
            LocalDate nextMonday  = jan26.with(TemporalAdjusters.firstDayOfNextMonth());
            assertThat(nextMonday).isEqualTo(2022, Month.FEBRUARY, 1);
        }

    }

    @Nested
    class FormattingDates {
        @Test
        @DisplayName("We can convert dates to a formatted string value")
        void createADateFromAFormattedString() {
            LocalDate jan26 = LocalDate.of(2022, 1, 26);

            String formattedDate = jan26.format(DateTimeFormatter.ofPattern("MMM dd, yyyy"));
            Assertions.assertThat(formattedDate).isEqualTo("Jan 26, 2022");
        }

    }


    private LocalDate findFollowingWeekDay(LocalDate startDate, DayOfWeek expectedDayOfWeek) {
        LocalDate followingDay = startDate;
        while (followingDay.getDayOfWeek() != expectedDayOfWeek) {
            followingDay = followingDay.plusDays(1);
        }
        return followingDay;
    }
}
