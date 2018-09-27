package com.epam.tat.realtor.util;

public class Parser {

    /**
     * parse input string to integer. Remove symbols excluding numbers
     * @param str which will be parse
     * @return number from string
     */
    public static Integer parse(String str){
        return Integer.valueOf(str.replaceAll("[^\\d.]","").trim());
    }

}