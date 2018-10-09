package com.epam.tat.realtor.util;

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