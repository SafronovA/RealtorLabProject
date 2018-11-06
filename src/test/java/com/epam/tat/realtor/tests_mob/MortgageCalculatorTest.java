package com.epam.tat.realtor.tests_mob;

import com.epam.tat.realtor.steps_mob.MortgageCalculatorPageStep;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MortgageCalculatorTest extends BaseTest {
    private MortgageCalculatorPageStep mortgageCalculatorPageStep;
    String loanType = "15-Year Fixed";
    String rate = "6";
    String homePrice = "110000";
    String downPayment = "10000";

    @Test
    public void mortgageCalculatorTest(
//            String loanType, String rate, String homePrice, String downPayment
    ) {

        mortgageCalculatorPageStep = homePageStep.clickFirstHouseCard()
                .clickEditMortgageCalculatorButton()
                .selectLoanType(loanType)
                .setRate(rate)
                .setHomePrice(homePrice)
                .setDownPayment(downPayment);
//                .selectLoanType(loanType);
        Assert.assertTrue(mortgageCalculatorPageStep.isDisplayedPriceCorrect(homePrice, downPayment, rate, loanType),
                "Mortgage calculator calculated incorrect monthly payment");
    }


//    /**
//     * data provider for mortgage test
//     *
//     * @return test parameters for calculator
//     */
//    @DataProvider(name = "mortgageData")
//    public static Object[][] dataForMortgageCalculatorTest(){
//        return new Object[][]{
//                {"15-Year Fixed","6","110000","10000"},
//                {"20-Year Fixed","8","1200000","300000"},
//                {"10-Year Fixed","10","560000","80000"},
//                {"30-Year Fixed","5","880000","10000"},
//                {"15-Year Fixed","6","9900000","500000"},
//                {"20-Year Fixed","7","450000","50000"},
//        };
//    }

}
