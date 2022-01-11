package com.serenitydojo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("When working with dates in Java 8")
class WhenWorkingWithDates {

    @DisplayName("The LocalDate class represents a date")
    @Nested
    class CreatingLocalDates {

        @Test
        @DisplayName("We can create a date by specifying the year, month and day")
        void creatingASimpleDate() {
        }

        @Test
        @DisplayName("We can create a date by using a string")
        void creatingASimpleDateFromAString() {
        }

        @Test
        @DisplayName("We can create a date by using a formatted string")
        void createADateFromAFormattedString() {
        }
    }

    @DisplayName("We can use LocalDates to find relative dates")
    @Nested
    class CreatingRelativeDates {
        @Test
        @DisplayName("We can create a date for the following day")
        void findTheNextDay() {
        }

        @Test
        @DisplayName("We can create a date for the following month")
        void findTheNextMonth() {
        }

        @Test
        @DisplayName("We can find a specific day of the week")
        void findTheNextMonday() {
        }

        @Test
        @DisplayName("We can find a specific day of the week using temporal adjusters")
        void usingTemporalAdjusters() {
        }

        @Test
        @DisplayName("We can find a specific day of the week using temporal adjusters")
        void usingTemporalAdjustersToGetTheNextOrCurrentDate() {
        }

        @Test
        @DisplayName("We can find the first day of the next month")
        void usingOtherTemporalAdjusters() {
        }

    }

    @Nested
    class FormattingDates {
        @Test
        @DisplayName("We can convert dates to a formatted string value")
        void createADateFromAFormattedString() {
        }

    }
}
