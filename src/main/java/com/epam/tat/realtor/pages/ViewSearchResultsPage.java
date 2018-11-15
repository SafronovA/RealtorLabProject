package com.epam.tat.realtor.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ViewSearchResultsPage extends BasePage {

    public ViewSearchResultsPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.move.realtor:id/address_text_view']")
    private List<AndroidElement> houseAddressesFromScreen;
    @AndroidFindBy(xpath = "//*[@text='Expand Search Area']")
    private List<AndroidElement> expandSearchAreaButton;
    @AndroidFindBy(xpath = "//android.widget.ListView/android.widget.FrameLayout")
    private List<WebElement> viewList;
    //    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.move.realtor:id/priceTextView']")
    @AndroidFindBy(id = "com.move.realtor:id/priceTextView")
    private List<WebElement> homePrice;
    //    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.move.realtor:id/bedroomCountTextView']")
    @AndroidFindBy(id = "com.move.realtor:id/bedroomCountTextView")
    private List<WebElement> homeBedCount;
    //    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.move.realtor:id/bathroomCountTextView']")
    @AndroidFindBy(id = "com.move.realtor:id/bathroomCountTextView")
    private List<WebElement> homeBathCount;
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.move.realtor:id/address_text_view']")
    private List<WebElement> homeAddress;
    @AndroidFindBy(xpath = "//android.widget.Button")
    private List<WebElement> expandButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.move.realtor:id/statusBadge']")
    private List<WebElement> homeStatus;

    public List<AndroidElement> getHouseAddressesFromScreen() {
        return houseAddressesFromScreen;
    }

    public List<AndroidElement> getExpandSearchAreaButton() {
        return expandSearchAreaButton;
    }

    public List<WebElement> getHomePrice() {
        return homePrice;
    }

    public List<WebElement> getHomeBedCount() {
        return homeBedCount;
    }

    public List<WebElement> getHomeBathCount() {
        return homeBathCount;
    }

    public List<WebElement> getHomeAddress() {
        return homeAddress;
    }

    public ViewSearchResultsPage swipeView() {
        WebElement view = viewList.get(0);
        int viewStartX = view.getLocation().x + 60;
        int viewStartY = view.getLocation().y;
        int viewHeight = view.getSize().height;
        swipeUp(viewStartX, viewStartY + viewHeight, viewStartX, 15);
        return new ViewSearchResultsPage(driver);
    }

    public int getExpandButton() {
        return expandButton.size();
    }

    public ViewSearchResultsPage waitForViewList() {
        waitUntilAllElementsAreVisible(By.xpath("//android.widget.ListView/android.widget.FrameLayout"));
        return this;
    }

    public List<WebElement> getHomeStatus() {
        return homeStatus;
    }


    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.move.realtor:id/sort_spinner\")")
    private AndroidElement sortByButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Filter\"]")
    private AndroidElement filterButton;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.move.realtor:id/priceTextView\")")
    private List<AndroidElement> homePricesList;
    //    @AndroidFindBy(xpath = "(//android.widget.ImageButton)[4]")
    @AndroidFindBy(xpath = "(//android.widget.ImageButton)[3]")
    private AndroidElement goBackButton;

    public List<AndroidElement> getHomePricesList() {
        return homePricesList;
    }

    public HousePage clickOnFirstHouse() {
        houseAddressesFromScreen.get(0).click();
        return new HousePage(driver);
    }

    public FilterPage clickFilterButton() {
        filterButton.click();
        return new FilterPage(driver);
    }

    public SortOptionsPage clickSortByButton() {
        waitUntilElementIsVisible(sortByButton);
        sortByButton.click();
        return new SortOptionsPage(driver);
    }

    public MainPage clickGoBackButton() {
        waitUntilElementIsVisible(goBackButton);
        goBackButton.click();
        return new MainPage(driver);
    }

}
