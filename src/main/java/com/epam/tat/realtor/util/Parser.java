package com.epam.tat.realtor.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    /**
     * parse String value removing any non digit character
     *
     * @param str string to be parsed
     * @return int value after parsing operation
     */
    public static Integer parse(String str) {
        return Integer.valueOf(str.replaceAll("[^\\d.]", "").trim());
    }

    /**
     * parse String value removing any non digit character
     *
     * @param str string to be parsed
     * @return String value after parsing operation
     */
    public static String parseToString(String str) {
        return str.replaceAll("[^\\d.]", "").trim();
    }

    /**
     * parse String value getting everything to the right of the last space
     *
     * @param str string to be parsed
     * @return String value after parsing operation
     */
    public static String getLastWord(String str) {
        String lastWord;
        Pattern pattern = Pattern.compile("\\s(\\w+)$");
        Matcher matcher = pattern.matcher(str);
        matcher.find();
        lastWord = matcher.group().trim();
        return lastWord;
    }

    /**
     * parse String value removing any non digit character with adding dimension
     *
     * @param str string to be parsed
     * @return int value after parsing operation
     */
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