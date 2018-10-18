package com.epam.tat.realtor.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


import java.util.Date;


public class TestListener implements ITestListener {

    private final Logger logger = LogManager.getRootLogger();
    protected static String testName;
    protected static Date data = new Date();
    private WebDriverListener webDriverListener;


    /**
     * Invoked each time before a test will be invoked.
     * Init testName current name of test, this name is use as name of folder screenshot to each test
     * Init props file "properties" from resources folder     *
     *
     * @param result
     */
    public void onTestStart(ITestResult result) {
        testName = result.getTestClass().getName();
        logger.info("Test start: " + testName);
    }

    /**
     * Invoked each time a test succeeds.
     *
     * @param result
     */
    public void onTestSuccess(ITestResult result) {

    }

    /**
     * Invoked each time a test fails.
     * Do screenshot when test fails and rename this screenshot to "FAIL"
     *
     * @param result
     */
    public void onTestFailure(ITestResult result) {
        webDriverListener = new WebDriverListener();
        webDriverListener.setStepTestScreenshot("FAIL");
        webDriverListener.screenshot();
    }

    /**
     * Invoked each time a test is skipped.
     *
     * @param result
     */
    public void onTestSkipped(ITestResult result) {

    }

    /**
     * Invoked each time a method fails but has been annotated with successPercentage
     * and this failure still keeps it within the success percentage requested.
     *
     * @param result
     */
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    /**
     * Invoked after the test class is instantiated and before any configuration method is called and init browser.
     *
     * @param context
     */
    public void onStart(ITestContext context) {

    }

    /**
     * Invoked after all the tests have run and all their Configuration methods have been called and close driver.
     *
     * @param context
     */
    public void onFinish(ITestContext context) {

    }

}
