package ru.javawebinar.topjava.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * GKislin
 * 07.01.2015.
 */
public class TimeUtil {
    public static final DateTimeFormatter DATE_TME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    public static final LocalDate MIN_DATE = LocalDate.of(0, 1, 1);
    public static final LocalDate MAX_DATE = LocalDate.of(4000, 0, 0);

    public static <T extends Comparable<? super T>> boolean isBetween(T value, T fromValue, T toValue) {
        return value.compareTo(fromValue) >= 0 && value.compareTo(toValue) <= 0;
    }

    public static String toString(LocalDateTime ldt) {
        return ldt == null ? "" : ldt.format(DATE_TME_FORMATTER);
    }
}
