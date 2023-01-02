package com.example.geektrust.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomDateFormatter {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");

    public static String formatDateToDdMmYyyy(Date date) {
        return sdf.format(date);
    }

    public static Date formatInputToDdMmYyyy(String date) {
        try {
            return sdf.parse(date);
        } catch (ParseException e) {
            System.out.println("Error Parsing the given date");
        }
        return null;
    }
}
