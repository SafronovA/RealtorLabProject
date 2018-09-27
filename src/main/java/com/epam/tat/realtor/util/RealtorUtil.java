package com.epam.tat.realtor.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class RealtorUtil {
    /**
     * parse String value removing any non digit character
     * @param str string to be parsed
     * @return int value after parsing operation
     */
    public static int parse(String str){
        return Integer.valueOf(str.replaceAll("[^\\d]","").trim());
    }

    /**
     * parse String value removing any non digit character with adding dimension
     * @param str string to be parsed
     * @return int value after parsing operation
     */
    public static int parsePrice(String str){
            int price = Integer.valueOf(str.replaceAll("[^\\d]","").trim());
            if (price<10) {return price*1000000;}
            else if (price<100) {return price*100000;}
            else {return price*1000;}
    }

    /**
     * click element by Java Executor
     * @param webElement web element to be clicked
     * @param webDriver used webdriver
     */
    public static void clickByJEx (WebElement webElement, WebDriver webDriver){
        JavascriptExecutor executor = (JavascriptExecutor) webDriver;
        executor.executeScript("arguments[0].click();", webElement);
    }

}
