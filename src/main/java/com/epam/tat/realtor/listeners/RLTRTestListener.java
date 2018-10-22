package com.epam.tat.realtor.listeners;

import com.epam.tat.realtor.drivers.DriverFactory;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RLTRTestListener implements ITestListener, ISuiteListener{
    private final Logger logger = LogManager.getRootLogger();
    @Override
    public void onTestStart(ITestResult iTestResult) {
        logger.info("Testing: " + getTestMethodName(iTestResult));
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        long timeTaken = ((iTestResult.getEndMillis() - iTestResult.getStartMillis()));
        logger.info("Tested: " + iTestResult.getName() + " Time taken:" + timeTaken + " ms");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        logger.info("Failed : "+ getTestMethodName(iTestResult));
        screenshot(iTestResult);

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        logger.info("Skipped Test: "+ getTestMethodName(iTestResult));
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {}

    @Override
    public void onStart(ITestContext iTestContext) {
        logger.info("Started testing on: " + iTestContext.getStartDate()
                .toString());
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        logger.info("PASSED TEST CASES");
        iTestContext.getPassedTests()
                .getAllResults()
                .forEach(result -> {
                    logger.info(result.getName());
                });
        logger.info("FAILED TEST CASES");
        iTestContext.getFailedTests()
                .getAllResults()
                .forEach(result -> {
                    logger.info(result.getName());
                });
        logger.info("Test completed on: " + iTestContext.getEndDate()
                .toString());
    }

    private static String getTestMethodName(ITestResult result){
        return result.getMethod().getConstructorOrMethod().getName();
    }
    public void screenshot(ITestResult iTestResult) {
        File scrFile = ((TakesScreenshot) DriverFactory.CHROMEDRIVER
                .getDriver())
                .getScreenshotAs(OutputType.FILE);
        String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "/src/test/resources";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatDateTime = LocalDateTime.now().format(formatter);
        File destFile = new File( reportDirectory+"/failure_screenshots/"+iTestResult.getMethod().getConstructorOrMethod().getName()+"_"+formatDateTime.replace(':','_')+".png");
        try {
        FileUtils.copyFile(scrFile, destFile);
        logger.info("save screenshot of failed test into "+destFile);

        } catch (IOException e) {
            System.out.println("Failed to save screenshot: " + e.getLocalizedMessage());
        }
    }

    @Override
    public void onStart(ISuite iSuite) {
        logger.info("*****************************");
        logger.info("Started suite "+ iSuite.getName());
        int[] count = {1};
        iSuite.getAllMethods().stream()
                .forEach(x-> logger.info("method #"+count[0]+++" "+x.getConstructorOrMethod().getName()));
    }

    @Override
    public void onFinish(ISuite iSuite) {
        logger.info("Suite "+ iSuite.getName()+" ended");
    }



}


