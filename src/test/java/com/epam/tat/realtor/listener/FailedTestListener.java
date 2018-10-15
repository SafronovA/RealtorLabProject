package com.epam.tat.realtor.listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class FailedTestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("Test " + iTestResult.getTestName() + " start");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("Test " + iTestResult.getTestName() + " success");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("Test " + iTestResult.getTestName() + " failed");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("Test " + iTestResult.getTestName() + " skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        
    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
