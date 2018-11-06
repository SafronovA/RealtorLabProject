package com.epam.tat.realtor.pages_mob;

import com.epam.tat.realtor.util.Parser;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPage extends BasePage {

    public MainPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Drawer Open']")
    private AndroidElement menuButton;
    @AndroidFindBy(id = "com.move.realtor:id/view_list_label")
    private AndroidElement viewListButton;
    @AndroidFindBy(id = "com.move.realtor:id/text_filter")
    private AndroidElement filterButton;
    @AndroidFindBy(id = "com.move.realtor:id/search_result_count_text_map")
    private AndroidElement resultsPopUp;
    @AndroidFindBy(id = "com.move.realtor:id/listingImageView")
    private AndroidElement firstHouseCard;

    /**
     * click  button
     *
     * @return this page
     */
    public MenuPage clickMenuButton() {
        menuButton.click();
        return new MenuPage(driver);
    }

    public FilterPage clickFilterButton(){
        waitUntilElementIsVisible(filterButton);
        filterButton.click();
        return new FilterPage(driver);
    }

    public ViewSearchResultsPage clickViewListButton(){
        viewListButton.click();
        return new ViewSearchResultsPage(driver);
    }

    public HousePage clickFirstHouseCard(){
        waitUntilElementIsVisible(firstHouseCard);
        firstHouseCard.click();
        return new HousePage(driver);
    }

    public int searchResultCount(){
        int result = Parser.parse(resultsPopUp.getText());
        return result;
    }

}
