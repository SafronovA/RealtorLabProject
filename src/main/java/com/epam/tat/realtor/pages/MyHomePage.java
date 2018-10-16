package com.epam.tat.realtor.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MyHomePage extends BasePage {

    public MyHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "edit-facts")
    private WebElement editHomeFactsButton;
    @FindBy(xpath = "//*[text()='Save']")
    private WebElement saveButton;
    @FindBy(className = "owner-verification-data-form__close-container")
    private WebElement closeAlertWindowButton;
    @FindBy(xpath = "(//*[@class='enhanced-input__field'])[4]")
    private WebElement bedroomsInput;
    @FindBy(xpath = "(//*[@class='enhanced-input__field'])[5]")
    private WebElement bathroomsInput;
    @FindBy(xpath = "(//*[@class='enhanced-input__field'])[6]")
    private WebElement carSpacesInput;
    @FindBy(xpath = "(//*[@class='enhanced-input__field'])[7]")
    private WebElement sqFootInput;
    @FindBy(xpath = "(//*[@class='enhanced-input__field'])[8]")
    private WebElement lotSizeInput;
    @FindBy(xpath = "//*[@data-reactid='134']//div")
    private List<WebElement> homeInfoList;

    /**
     * click edit home facts button
     *
     * @return this page
     */
    public MyHomePage clickEditHomeFactsButton() {
        waitUntilElementIsClickable(editHomeFactsButton);
        editHomeFactsButton.click();
        return this;
    }

    /**
     * click save button
     *
     * @return this page
     */
    public MyHomePage clickSaveButton() {
        saveButton.click();
        return this;
    }

    /**
     * click close alert window button
     *
     * @return this page
     */
    public MyHomePage closeAlertWindow() {
        closeAlertWindowButton.click();
        return this;
    }

    /**
     * clear bedrooms input field
     * enter bedrooms value
     *
     * @param bedrooms number of bedrooms
     * @return this page
     */
    public MyHomePage enterBedrooms(String bedrooms) {
        clearField(bedroomsInput);
        bedroomsInput.sendKeys(bedrooms);
        return this;
    }

    /**
     * clear bathrooms input field
     * enter bathrooms value
     *
     * @param bathrooms number of bathrooms
     * @return this page
     */
    public MyHomePage enterBathrooms(String bathrooms) {
        clearField(bathroomsInput);
        bathroomsInput.sendKeys(bathrooms);
        return this;
    }

    /**
     * clear car paces input field
     * enter car spaces value
     *
     * @param carSpaces number of car spaces
     * @return this page
     */
    public MyHomePage enterCarSpaces(String carSpaces) {
        clearField(carSpacesInput);
        carSpacesInput.sendKeys(carSpaces);
        return this;
    }

    /**
     * clear sqFoot input field
     * enter sqFoot value
     *
     * @param sqFoot sqFoot value
     * @return this page
     */
    public MyHomePage enterSqFoot(String sqFoot) {
        clearField(sqFootInput);
        sqFootInput.sendKeys(sqFoot);
        return this;
    }

    /**
     * clear lotSize input field
     * enter lotSize value
     *
     * @param lotSize lotSize value
     * @return this page
     */
    public MyHomePage enterLotSize(String lotSize) {
        clearField(lotSizeInput);
        lotSizeInput.sendKeys(lotSize);
        return this;
    }

    /**
     * get list of web elements, that contains home info
     *
     * @return homeInfoList web element
     */
    public List<WebElement> getHomeInfoList() {
        try {                        //no other way of waiting gives 100% result
            Thread.sleep(2000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        return homeInfoList;
    }

    /**
     * delete text in field
     *
     * @param field which text will be delete in
     * @return this page
     */
    private MyHomePage clearField(WebElement field) {
        field.sendKeys(Keys.CONTROL + "a");
        field.sendKeys(Keys.DELETE);
        return this;
    }

}
