package com.victoria.parabank.utils;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateUtils {
    public String currentDate() {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = today.format(formatter);
        return formattedDate;

    }

    public String currentDateTime() {
        LocalTime current = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formattedTime = current.format(formatter);
        return formattedTime;
    }

    public String addDays(int days) {
        LocalDate today = LocalDate.now();
        LocalDate futureDate = today.plusDays(days);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = futureDate.format(formatter);
        return formattedDate;
    }

    public String timestamp() {
        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        return current.format(formatter);
    }

    public String formatDate(LocalDate date, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        String formattedDate = date.format(formatter);
        return formattedDate;
    }

    public LocalDate parseDate(String dateText, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        LocalDate parseDate = LocalDate.parse(dateText, formatter);
        return parseDate;
    }

    public long daysBetween(LocalDate start, LocalDate end) {
        return ChronoUnit.DAYS.between(start, end);
    }

    public String isBeforeOrAfter(LocalDate first, LocalDate second) {
        if (first.isBefore(second)) {
            return "The first date is before the second.";
        } else if (first.isAfter(second)) {
            return "The first date is after the second.";
        } else {
            return "The dates are equal.";
        }
    }
}