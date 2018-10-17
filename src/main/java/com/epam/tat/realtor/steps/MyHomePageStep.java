package com.epam.tat.realtor.steps;

import com.epam.tat.realtor.bo.House;
import com.epam.tat.realtor.pages.MyHomePage;
import org.openqa.selenium.WebDriver;

public class MyHomePageStep extends BasePageStep {
    private MyHomePage myHomePage;
    private House house;

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
                .enterSquare(sqFoot)
                .enterLotSize(lotSize)
                .clickSaveButton()
                .closeVerificationWindows();
        return this;
    }

    /**
     * getting a house business object
     */
    public void getHouse(){
        house = myHomePage.getHouse();
    }

    /**
     * perform operation of comparing required and current bedrooms value
     *
     * @param bedrooms required bedrooms value
     * @return boolean
     */
    public boolean bedroomsValueIsCorrect(String bedrooms) {
        getHouse();
        String houseBedrooms = String.valueOf(house.getBedNumber());
        return houseBedrooms.equals(bedrooms);
    }

    /**
     * perform operation of comparing required and current bathrooms value
     *
     * @param bathrooms required bathrooms value
     * @return boolean
     */
    public boolean bathroomsValueIsCorrect(String bathrooms) {
        String houseBathrooms = String.valueOf(house.getBathNumber());
        return houseBathrooms.equals(bathrooms);
    }

    /**
     * perform operation of comparing required and current carSpaces value
     *
     * @param carSpaces required carSpaces value
     * @return boolean
     */
    public boolean carSpacesValueIsCorrect(String carSpaces) {
        String houseCarSpaces = String.valueOf(house.getCarSpaces());
        return houseCarSpaces.equals(carSpaces);
    }

    /**
     * perform operation of comparing required and current sqFoot value
     *
     * @param square required square value
     * @return boolean
     */
    public boolean sqFootValueIsCorrect(String square) {
        String houseSquare = String.valueOf(house.getSquare());
        return houseSquare.equals(square);
    }

    /**
     * perform operation of comparing required and current lotSize value
     *
     * @param lotSize required lotSize value
     * @return boolean
     */
    public boolean lotSizeIsCorrect(String lotSize) {
        String houseLotSize = String.valueOf(house.getLotSize());
        return houseLotSize.equals(lotSize);
    }

}
