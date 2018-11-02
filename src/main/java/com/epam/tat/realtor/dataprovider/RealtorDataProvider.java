package com.epam.tat.realtor.dataprovider;

import org.testng.annotations.DataProvider;

public class RealtorDataProvider {

    /**
     * data provider for mortgage test
     *
     * @return test parameters for calculator
     */
    @DataProvider(name = "mortgageData")
    public static Object[][] dataForMortgageCalculatorTest(){
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
