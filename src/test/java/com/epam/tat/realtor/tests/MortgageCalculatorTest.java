package com.epam.tat.realtor.tests;

import com.epam.tat.realtor.steps.MortgageCalculatorPageStep;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MortgageCalculatorTest extends BaseTest {

    private static String LOAN_TYPE = "15-Year Fixed";
    private static String RATE = "6";
    private static String HOME_PRICE = "110000";
    private static String DOWN_PAYMENT = "10000";

    @Test
    public void mortgageCalculatorTest() {
        MortgageCalculatorPageStep mortgageCalculatorPageStep = homePageStep.navigateCursorToMortgageLink()
                .clickMortgageCalculatorLink()
                .selectLoanType(LOAN_TYPE)
                .setRate(RATE)
                .setHomePrice(HOME_PRICE)
                .setDownPayment(DOWN_PAYMENT);
        Assert.assertTrue(mortgageCalculatorPageStep.isDisplayedPriceCorrect(HOME_PRICE, DOWN_PAYMENT, RATE, LOAN_TYPE),
                "Mortgage calculator calculated incorrect monthly payment");
    }

}
