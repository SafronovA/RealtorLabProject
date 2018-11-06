package com.epam.tat.realtor.util;

public class Parser {

    public static Integer parse(String str) {
        return Integer.valueOf(str.replaceAll("[^\\d.]", "").trim());
    }

}