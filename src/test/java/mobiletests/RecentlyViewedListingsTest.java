package mobiletests;

import org.testng.annotations.Test;

public class RecentlyViewedListingsTest extends BaseTest {

    private static final String CITY = "San Francisco, CA"

    @Test
    public void recentlyViewedListings() {
        homePageStep.clickMenuButton()
                .clickStartNewSearch()
                .enterCity(CITY)

    }

}
