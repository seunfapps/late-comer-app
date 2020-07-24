package com.seunfapps.latecomer.utilities;

import org.joda.time.Duration;
import org.joda.time.LocalTime;
import org.joda.time.Minutes;

public class EmployeeEntryLogUtil {
    public static double calculateAmountOwed(LocalTime arrivalTime){
        //assume everyone who arrives after 8am is late.
        LocalTime deadline = new LocalTime("08:00:00");
        int minutes = Minutes.minutesBetween(deadline,arrivalTime).getMinutes();
        return minutes * 0.2;
    }
}
