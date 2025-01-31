package ru.codreview.tests.utils;

import lombok.experimental.UtilityClass;

import java.time.LocalTime;

@UtilityClass
public class DumbUtils {

    public static String timeOfDay() {
        int hour = LocalTime.now().getHour();
        if (hour > 5 && hour < 12) {
            return "Morning";
        } else if (hour > 12 && hour < 18) {
            return "Afternoon";
        } else if (hour < 22) {
            return "Evening";
        } else {
            return "Night";
        }
    }

}
