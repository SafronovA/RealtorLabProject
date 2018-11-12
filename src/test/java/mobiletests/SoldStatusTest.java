package mobiletests;

import com.epam.tat.realtor.steps.ViewPageStep;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SoldStatusTest extends BaseTest{
    private final String CITY_NAME = "San Francisco, CA";
    private final String MIN_PRICE_VALUE = "370000";
    private final String MAX_PRICE_VALUE = "475000";


    @Test
    void checkHomeStatus() {
        ViewPageStep viewPageStep =homePageStep.clickMenuButton()
                .startNewSearch()
                .enterSearchCity(CITY_NAME)
                .enterFilterSection()
                .createFilterRequest(MIN_PRICE_VALUE,MAX_PRICE_VALUE).clickMenuButton().selectSoldStatus().showListView();
        Assert.assertTrue(viewPageStep.checkSoldStatus());

    }
}
