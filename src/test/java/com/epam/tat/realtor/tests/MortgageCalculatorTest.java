package com.epam.tat.realtor.tests;

import com.epam.jira.JIRATestKey;
import com.epam.jira.testng.RetryAnalyzer;
import com.epam.tat.realtor.listeners.IAnnotationTransformerListener;
import com.epam.tat.realtor.steps.MortgageCalculatorPageStep;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(IAnnotationTransformerListener.class)
public class MortgageCalculatorTest extends BaseTest {

    /**
     * check that calculated and displayed price is correct
     */
    @JIRATestKey(key = "EPMFARMATS-4931", retryCountIfFailed = 2)
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void mortgageCalculatorTest(String loanType, String rate, String homePrice, String downPayment) {
        MortgageCalculatorPageStep mortgageCalculatorPageStep = homePageStep.navigateCursorToMortgageLink()
                .clickMortgageCalculatorLink()
                .selectLoanType(loanType)
                .setRate(rate)
                .setHomePrice(homePrice)
                .setDownPayment(downPayment);
        Assert.assertTrue(mortgageCalculatorPageStep.isDisplayedPriceCorrect(homePrice, downPayment, rate, loanType),
                "Mortgage calculator calculated incorrect monthly payment");
    }

}
