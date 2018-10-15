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
        MortgageCalculatorPageStep mortgageCalculatorPageStep = new MortgageCalculatorPageStep(driver);
        homePageStep.navigateCursorToMortgageLink();
        homePageStep.clickMortgageCalculatorLink();
        mortgageCalculatorPageStep.selectLoanType(loanType);
        mortgageCalculatorPageStep.setRate(rate);
        mortgageCalculatorPageStep.setHomePrice(homePrice);
        mortgageCalculatorPageStep.setDownPayment(downPayment);
        Assert.assertTrue(mortgageCalculatorPageStep.isDisplayedPriceCorrect(homePrice, downPayment, rate, loanType),
                "Mortgage calculator calculated incorrect monthly payment");
    }

    /**
     * data provider for test
     *
     * @return test parameters for calculator
     */
    @DataProvider(name = "mortgageData")
    public static Object[][] data(){
        return new Object[][]{
                {"15-Year Fixed","6","110000","10000"},
                {"20-Year Fixed","8","1200000","300000"},
                {"10-Year Fixed","10","560000","80000"},
                {"30-Year Fixed","5","880000","10000"},
                {"15-Year Fixed","6","9900000","500000"},
                {"20-Year Fixed","7","450000","50000"},
        };
    }

}
