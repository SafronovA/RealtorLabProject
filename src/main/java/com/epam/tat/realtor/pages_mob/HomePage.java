package com.epam.tat.realtor.pages_mob;

import com.epam.tat.realtor.util.Parser;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BasePage {

    public HomePage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Drawer Open']")
    private AndroidElement menuButton;
    @AndroidFindBy(id = "com.move.realtor:id/view_list_label")
    private AndroidElement viewListButton;
    @AndroidFindBy(id = "com.move.realtor:id/text_filter")
    private AndroidElement filterButton;
    @AndroidFindBy(xpath = "//*[@resource-id='com.move.realtor:id/search_editor_tab_clear_icon']")
    private AndroidElement clearCityIcon;
    @AndroidFindBy(id = "com.move.realtor:id/search_editor_tab_location_frame")
    private AndroidElement cityInput;
    @AndroidFindBy(id = "com.move.realtor:id/search_editor_tab_min_price")
    private AndroidElement minPriceInput;
    @AndroidFindBy(id = "com.move.realtor:id/search_editor_tab_max_price")
    private AndroidElement maxPriceInput;
    @AndroidFindBy(id = "com.move.realtor:id/search_editor_view_results_btn")
    private AndroidElement viewResultsButton;
    @AndroidFindBy(id = "com.move.realtor:id/search_result_count_text_map")
    private AndroidElement resultsPopUp;
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.move.realtor:id/address_text_view']")
    private List<AndroidElement> houseAddressesFromScreen;
    @AndroidFindBy(xpath = "//*[@text='Expand Search Area']")
    private List<AndroidElement> expandSearchAreaButton;

    /**
     * click  button
     *
     * @return this page
     */
    public HomePage clickMenuButton() {
        menuButton.click();
        return this;
    }

    public HomePage clickFilterButton(){
        waitUntilElementIsVisible(filterButton);
        filterButton.click();
        return this;
    }

    public HomePage clickClearCityIcon(){
        clearCityIcon.click();
        return this;
    }

    public HomePage enterCity(String city){
        cityInput.sendKeys(city);
        return this;
    }

    public HomePage enterMinPrice(String minPrice){
        minPriceInput.sendKeys(minPrice);
        return this;
    }
    public HomePage enterMaxPrice(String maxPrice){
        maxPriceInput.sendKeys(maxPrice);
        return this;
    }

    public HomePage openViewPage(){
        viewListButton.click();
        return this;
    }

    public HomePage clickViewResultsButton(){
        viewResultsButton.click();
        return this;
    }

    public int searchResultCount(){
        int result = Parser.parse(resultsPopUp.getText());
        return result;
    }

    public List<AndroidElement> getHouseAddressesFromScreen(){
        return houseAddressesFromScreen;
    }

    public List<AndroidElement> getExpandSearchAreaButton() {
        return expandSearchAreaButton;
    }
}
