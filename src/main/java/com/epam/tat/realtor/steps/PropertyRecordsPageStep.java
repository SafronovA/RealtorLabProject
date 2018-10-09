package com.epam.tat.realtor.steps;

import com.epam.tat.realtor.pages.PropertyRecordsPage;
import org.omg.CORBA.TIMEOUT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class PropertyRecordsPageStep extends BasePageStep {
    private PropertyRecordsPage propertyRecordsPage;

    public PropertyRecordsPageStep(WebDriver driver) {
        super(driver);
        propertyRecordsPage = new PropertyRecordsPage(driver);
    }


    public boolean checkPropertyRecords() {
        return getCharsList().stream().allMatch(x -> {
            driver.findElement(By.xpath("//ul[@class='list-horizontal street-pagination']/li/a[text()='" + x + "']"))
                    .click();
            return propertyRecordsPage.getPropertyRecordsList().stream()
                    .allMatch(o -> o.getText().substring(0, 1).equals(x));
        });
    }

    private List<String> getCharsList() {
        List<String> charList = new ArrayList<>();
        propertyRecordsPage.getCharList().stream()
                .filter(x -> !x.getText().equalsIgnoreCase("All"))
                .forEach(x -> charList.add(x.getText()));
        return charList;
    }

}
