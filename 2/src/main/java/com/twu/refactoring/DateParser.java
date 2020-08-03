package com.twu.refactoring;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.TimeZone;

public class DateParser {
    public static final String YEAR_STRING_EXCEPTION = "Year string is less than 4 characters";
    public static final String YEAR_NUMBER_EXCEPTION = "Year is not an integer";
    public static final String YEAR_CHECK_EXCEPTION = "Year cannot be less than 2000 or more than 2012";
    public static final String MONTH_STRING_EXCEPTION = "Month string is less than 2 characters";
    public static final String MONTH_NUMBER_EXCEPTION = "Month is not an integer";
    public static final String MONTH_CHECK_EXCEPTION = "Month cannot be less than 1 or more than 12";
    public static final String DATE_STRING_EXCEPTION = "Date string is less than 2 characters";
    public static final String DATE_NUMBER_EXCEPTION = "Date is not an integer";
    public static final String DATE_CHECK_EXCEPTION = "Date cannot be less than 1 or more than 31";
    public static final String HOUR_STRING_EXCEPTION = "Hour string is less than 2 characters";
    public static final String HOUR_NUMBER_EXCEPTION = "Hour is not an integer";
    public static final String HOUR_CHECK_EXCEPTION = "Hour cannot be less than 0 or more than 23";
    public static final String MINUTE_STRING_EXCEPTION = "Minute string is less than 2 characters";
    public static final String MINUTE_NUMBER_EXCEPTION = "Minute is not an integer";
    public static final String MINUTE_CHECK_EXCEPTION = "Minute cannot be less than 0 or more than 59";
    private final String dateAndTimeString;
    private static final HashMap<String, TimeZone> KNOWN_TIME_ZONES = new HashMap<String, TimeZone>();

    static {
        KNOWN_TIME_ZONES.put("UTC", TimeZone.getTimeZone("UTC"));
    }

    /**
     * Takes a date in ISO 8601 format and returns a date
     *
     * @param dateAndTimeString - should be in format ISO 8601 format
     *                          examples -
     *                          2012-06-17 is 17th June 2012 - 00:00 in UTC TimeZone
     *                          2012-06-17TZ is 17th June 2012 - 00:00 in UTC TimeZone
     *                          2012-06-17T15:00Z is 17th June 2012 - 15:00 in UTC TimeZone
     */
    public DateParser(String dateAndTimeString) {
        this.dateAndTimeString = dateAndTimeString;
    }

    public Date parse() {
        int year, month, date, hour, minute;

        year = getNumFromDataAndTimeString(0, 4, YEAR_STRING_EXCEPTION, YEAR_NUMBER_EXCEPTION);
        checkData(year, 2000, 2012, YEAR_CHECK_EXCEPTION);

        month = getNumFromDataAndTimeString(5, 7, MONTH_STRING_EXCEPTION, MONTH_NUMBER_EXCEPTION);
        checkData(month, 1, 12, MONTH_CHECK_EXCEPTION);

        date = getNumFromDataAndTimeString(8, 10, DATE_STRING_EXCEPTION, DATE_NUMBER_EXCEPTION);
        checkData(date, 1, 31, DATE_CHECK_EXCEPTION);

        if (dateAndTimeString.substring(11, 12).equals("Z")) {
            hour = 0;
            minute = 0;
        } else {
            hour = getNumFromDataAndTimeString(11, 13, HOUR_STRING_EXCEPTION, HOUR_NUMBER_EXCEPTION);
            checkData(hour, 0, 23, HOUR_CHECK_EXCEPTION);

            minute = getNumFromDataAndTimeString(14, 16, MINUTE_STRING_EXCEPTION, MINUTE_NUMBER_EXCEPTION);
            checkData(minute, 0, 59, MINUTE_CHECK_EXCEPTION);
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("UTC"));
        calendar.set(year, month - 1, date, hour, minute, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public int getNumFromDataAndTimeString(int startIndex, int endIndex, String stringException, String numberException) {
        try {
            String string = dateAndTimeString.substring(startIndex, endIndex);
            return Integer.parseInt(string);
        } catch (StringIndexOutOfBoundsException e) {
            throw new IllegalArgumentException(stringException);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(numberException);
        }
    }

    public void checkData(int data, int start, int end, String checkException) {
        if (data < start || data > end)
            throw new IllegalArgumentException(checkException);
    }
}
