package mobiletests;

import com.epam.tat.realtor.steps.HousePageStep;
import com.epam.tat.realtor.steps.RecentlyViewedListingsPageStep;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RecentlyViewedListingsTest extends BaseTest {

    private static final String CITY = "San Francisco, CA";

    @Test
    public void recentlyViewedListings() {
        HousePageStep housePageStep = homePageStep.clickMenuButton()
                .clickStartNewSearch()
                .enterCity(CITY)
                .clickViewListButton()
                .clickOnFirstHouse();
        String houseAddress = housePageStep.getHouseAddress();
        HousePageStep recentlyHousePageStep = housePageStep.clickGoBackButton()
                .clickGoBackButton()
                .clickMenuButton()
                .clickRecentlyViewedListingsButton()
                .clickOnFirstHouse();
        Assert.assertEquals(houseAddress, recentlyHousePageStep.getHouseAddress(),
                "Addresses do not match");
    }

}
