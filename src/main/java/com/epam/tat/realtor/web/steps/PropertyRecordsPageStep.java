package com.epam.tat.realtor.web.steps;

import com.epam.tat.realtor.web.pages.PropertyRecordsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class PropertyRecordsPageStep extends BasePageStep {
    private PropertyRecordsPage propertyRecordsPage;

    public PropertyRecordsPageStep(WebDriver driver) {
        super(driver);
        propertyRecordsPage = new PropertyRecordsPage(driver);
    }

    /**
     * check if all property record start with proper character
     *
     * @return method check result
     */
    public boolean checkPropertyRecords() {
        return getCharsList().stream()
                .allMatch(x -> {
                    propertyRecordsPage.findElementByText(x)
                            .click();
                    return propertyRecordsPage.getPropertyRecordsList()
                            .stream()
                            .allMatch(o -> o.getText().startsWith(x));
                });
    }

    /**
     * get list of available chars for property records
     *
     * @return list of available chars for property records
     */
    private List<String> getCharsList() {
        return propertyRecordsPage.getCharList().stream()
                .skip(1)
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

}
