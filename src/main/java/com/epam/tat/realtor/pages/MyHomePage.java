package com.epam.tat.realtor.pages;

import com.epam.tat.realtor.bo.House;
import com.epam.tat.realtor.util.Parser;
import org.openqa.selenium.By;
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

    private By verificationButton = By.xpath("//*[@class='owner-verification-data-form__action-button call-to-action__button centered col-xxxs-12 margin-top-lg']");
    @FindBy(className = "edit-facts")
    private WebElement editHomeFactsButton;
    @FindBy(xpath = "//*[text()='Save']")
    private WebElement saveButton;
    @FindBy(className = "owner-verification-data-form__close-container")
    private WebElement closeVerificationWindowButton;
    @FindBy(xpath = "//*[@name='beds']")
    private WebElement bedroomsInput;
    @FindBy(xpath = "//*[@name='baths']")
    private WebElement bathroomsInput;
    @FindBy(xpath = "//*[@name='garage']")
    private WebElement carSpacesInput;
    @FindBy(xpath = "//*[@name='buildingSize']")
    private WebElement squareInput;
    @FindBy(xpath = "//*[@name='lotSize']")
    private WebElement lotSizeInput;
    @FindBy(xpath = "//*[@class='homefacts-item']")
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
    public MyHomePage closeVerificationWindows() {
        waitUntilElementIsVisible(verificationButton);
        closeVerificationWindowButton.click();
        waitInvisibilityOfElementLocated(verificationButton);
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
     * clear square input field
     * enter square value
     *
     * @param square value
     * @return this page
     */
    public MyHomePage enterSquare(String square) {
        clearField(squareInput);
        squareInput.sendKeys(square);
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
     * create an business object of the house based on the data on the page
     *
     * @return new House()
     */
    public House getHouse() {
        int bedNumber = getHouseParameterByName("Bedrooms");
        int bathNumber = getHouseParameterByName("Bathrooms");
        int square = getHouseParameterByName("Sq. Ft.");
        int lotSize = getHouseParameterByName("Lot Size");
        int carSpaces = getHouseParameterByName("Car Spaces");
        return new House(bedNumber, bathNumber, square, lotSize, carSpaces);
    }

    /**
     * finds the required element by its name and returns its value
     *
     * @param name find elemetn with such name
     * @return some house parameter by parameter's name
     */
    private int getHouseParameterByName(String name) {
        return Parser.parse(homeInfoList.stream()
                .filter(x -> x.findElement(By.xpath("span")).getText().equals(name))
                .findFirst().get()
                .findElement(By.xpath("div"))
                .getText());
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
