package com.epam.tat.realtor.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    public static Integer parse(String str) {
        return Integer.valueOf(str.replaceAll("[^\\d.]", "").trim());
    }

    public static String parseToString(String str) {
        return str.replaceAll("[^\\d.]", "").trim();
    }

    public static String getLastWord(String str) {
        String lastWord;
        Pattern pattern = Pattern.compile("\\s(\\w+)$");
        Matcher matcher = pattern.matcher(str);
        matcher.find();
        lastWord = matcher.group().trim();
        return lastWord;
    }

    public static int parsePrice(String str) {
        int price = Integer.valueOf(str.replaceAll("[^\\d]", "").trim());
        if (price < 10) {
            return price * 1000000;
        } else if (price < 100) {
            return price * 100000;
        } else {
            return price * 1000;
        }
    }
}