package com.epam.tat.realtor.tests;

import com.epam.tat.realtor.steps.MortgageCalculatorPageStep;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MortgageCalculatorTest extends BaseTest {

    /**
     * check that calculated and displayed price is correct
     */
    @Test(dataProvider = "mortgageData")
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
