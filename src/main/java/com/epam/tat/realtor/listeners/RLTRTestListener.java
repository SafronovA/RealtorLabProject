package com.epam.tat.realtor.listeners;

import com.epam.tat.realtor.drivers.DriverFactory;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.*;
import org.testng.xml.XmlSuite;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RLTRTestListener implements ITestListener, ISuiteListener, IReporter{
    private final Logger logger = LogManager.getRootLogger();
    @Override
    public void onTestStart(ITestResult iTestResult) {
        logger.info("test method "+ getTestMethodName(iTestResult)+" start");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        logger.info("test method "+ getTestMethodName(iTestResult)+" success");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        logger.info("test method "+ getTestMethodName(iTestResult)+" fail");
        screenshot(iTestResult);

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        logger.info("test method "+ getTestMethodName(iTestResult)+" skip");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {}

    @Override
    public void onStart(ITestContext iTestContext) {}

    @Override
    public void onFinish(ITestContext iTestContext) {}

    private static String getTestMethodName(ITestResult result){
        return result.getMethod().getConstructorOrMethod().getName();
    }
    public void screenshot(ITestResult iTestResult) {
        File scrFile = ((TakesScreenshot) DriverFactory.CHROMEDRIVER
                .getDriver())
                .getScreenshotAs(OutputType.FILE);
        String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "/src/test/resources";
        File destFile = new File( reportDirectory+"/failure_screenshots/"+iTestResult.getMethod().getConstructorOrMethod().getName()+"_"+LocalDate.now()+".png");
        try {
        FileUtils.copyFile(scrFile, destFile);
        String fileName = ".//target/screenshots/"  + "/"
                + LocalDateTime.now() + "/" + iTestResult.getMethod().getConstructorOrMethod().getName() + ".png";
        logger.info("save screenshot of faild test into "+fileName);

        } catch (IOException e) {
            System.out.println("Failed to save screenshot: " + e.getLocalizedMessage());
        }
    }

    @Override
    public void onStart(ISuite iSuite) {
        logger.info("*****************************");
        logger.info("suite "+ iSuite.getName()+" start");
        int[] count = {1};
        iSuite.getAllMethods().stream()
                .forEach(x-> logger.info("method #"+count[0]+++" "+x.getConstructorOrMethod().getName()));
    }

    @Override
    public void onFinish(ISuite iSuite) {
        logger.info("suite "+ iSuite.getName()+" end");
    }

    @Override
    public void generateReport(List<XmlSuite>  xmlSuites, List<ISuite> suites, String outputDirectory) {
        suites.stream().forEach(suite -> {
            List<ITestNGMethod> allMethods = suite.getAllMethods();
            allMethods.stream().forEach(method->method.);
            logger.info("*************************************");
                    logger.info("Report for suite: " + suite.getName());

                    System.out.println("*****End of Report******");
                }
        );
    }

}


