package com.epam.tat.realtor.steps;

import com.epam.tat.realtor.pages.MyHomePage;
import com.epam.tat.realtor.util.Parser;
import org.openqa.selenium.WebDriver;

public class MyHomePageStep extends BasePageStep {
    private MyHomePage myHomePage;

    public MyHomePageStep(WebDriver driver) {
        super(driver);
        myHomePage = new MyHomePage(driver);
    }

    /**
     * perform edit home info operation
     * click edit home facts button
     * enter bedrooms value
     * enter bathrooms value
     * enter carSpaces value
     * enter sqFoot value
     * enter lotSize value
     * click save button
     * close alert window
     *
     * @param bedrooms  number of bedrooms
     * @param bathrooms number of bathrooms
     * @param carSpaces number of car spaces
     * @param sqFoot    sqFoot value
     * @param lotSize   lotSize value
     * @return this step
     */
    public MyHomePageStep editHomeInfo(String bedrooms, String bathrooms, String carSpaces, String sqFoot, String lotSize) {
        myHomePage.clickEditHomeFactsButton()
                .enterBedrooms(bedrooms)
                .enterBathrooms(bathrooms)
                .enterCarSpaces(carSpaces)
                .enterSqFoot(sqFoot)
                .enterLotSize(lotSize)
                .clickSaveButton()
                .closeAlertWindow();
        return this;
    }

    /**
     * perform operation of comparing required and current bedrooms value
     *
     * @param bedrooms required bedrooms value
     * @return boolean
     */
    public boolean bedroomsValueIsCorrect(String bedrooms) {
        String bedroomsValue = myHomePage
                .getHomeInfoList()
                .get(0)
                .getText();
        boolean result = Parser.parseToString(bedroomsValue).equals(bedrooms);
        return result;
    }

    /**
     * perform operation of comparing required and current bathrooms value
     *
     * @param bathrooms required bathrooms value
     * @return boolean
     */
    public boolean bathroomsValueIsCorrect(String bathrooms) {
        String bathroomsValue = myHomePage
                .getHomeInfoList()
                .get(1)
                .getText();
        boolean result = Parser.parseToString(bathroomsValue).equals(bathrooms);
        return result;
    }

    /**
     * perform operation of comparing required and current carSpaces value
     *
     * @param carSpaces required carSpaces value
     * @return boolean
     */
    public boolean carSpacesValueIsCorrect(String carSpaces) {
        String carSpacesValue = myHomePage
                .getHomeInfoList()
                .get(4)
                .getText();
        boolean result = Parser.parseToString(carSpacesValue).equals(carSpaces);
        return result;
    }

    /**
     * perform operation of comparing required and current sqFoot value
     *
     * @param sqFoot required sqFoot value
     * @return boolean
     */
    public boolean sqFootValueIsCorrect(String sqFoot) {
        String sqFootValue = myHomePage
                .getHomeInfoList()
                .get(2)
                .getText();
        boolean result = Parser.parseToString(sqFootValue).equals(sqFoot);
        return result;
    }

    /**
     * perform operation of comparing required and current lotSize value
     *
     * @param lotSize required lotSize value
     * @return boolean
     */
    public boolean lotSizeIsCorrect(String lotSize) {
        String lotSizeValue = myHomePage
                .getHomeInfoList()
                .get(3)
                .getText();
        boolean result = Parser.parseToString(lotSizeValue).equals(lotSize);
        return result;
    }

}
