package com.epam.tat.realtor.tests;

import com.epam.tat.realtor.steps.MortgageCalculatorPageStep;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MortgageCalculatorTest extends BaseTest {
    private MortgageCalculatorPageStep mortgageCalculatorPageStep;

    @BeforeClass
    public void goToMortgageCalc() {
        mortgageCalculatorPageStep = mainPageStep
                .clickFirstHouseCard()
                .clickEditMortgageCalculatorButton();
    }

    @Test(dataProvider = "mortgageData")
    public void mortgageCalculatorTest(String loanType, String rate, String homePrice, String downPayment) {
        mortgageCalculatorPageStep.selectLoanType(loanType)
                .setRate(rate)
                .setHomePrice(homePrice)
                .setDownPayment(downPayment);
        Assert.assertTrue(mortgageCalculatorPageStep.isDisplayedPriceCorrect(homePrice, downPayment, rate, loanType),
                "Mortgage calculator calculated incorrect monthly payment");
    }

    @DataProvider(name = "mortgageData")
    public static Object[][] data() {
        return new Object[][]{
                {"15-Year Fixed", "6", "110000", "10000"},
                {"10-Year Fixed","10","560000","80000"},
                {"30-Year Fixed", "5", "880000", "10000"},
        };
    }


}
