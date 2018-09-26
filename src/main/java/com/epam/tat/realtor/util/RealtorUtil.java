package com.epam.tat.realtor.util;

import java.util.concurrent.TimeUnit;

public class RealtorUtil {

    public static int parse(String str){
        return Integer.valueOf(str.replaceAll("[^\\d]","").trim());
    }
    public static int parse(String str, int dimension){
            return Integer.valueOf(str.replaceAll("[^\\d]","").trim())*dimension;
    }
    public static void sleep(int milliseconds){
        try {
            TimeUnit.MILLISECONDS.sleep((long)milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
