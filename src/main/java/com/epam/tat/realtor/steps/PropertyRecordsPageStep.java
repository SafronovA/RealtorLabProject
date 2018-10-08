package com.epam.tat.realtor.steps;

import com.epam.tat.realtor.pages.PropertyRecordsPage;
import org.omg.CORBA.TIMEOUT;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PropertyRecordsPageStep extends BasePageStep {
    private PropertyRecordsPage propertyRecordsPage;

    public PropertyRecordsPageStep(WebDriver driver) {
        super(driver);
        propertyRecordsPage = new PropertyRecordsPage(driver);
    }

    public void checkPropertyRecords(){
        List<WebElement> charList = propertyRecordsPage.getCharList();
        charList.stream().filter(x->!x.getText().equalsIgnoreCase("All"))
                .forEach(x->{
                    propertyRecordsPage.waitUntilElementIsClickable(x);
                    x.click();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
//                   propertyRecordsPage.waitForJQueryIsLoad();
//
//                    propertyRecordsPage.getPropertyRecordsList().forEach(k-> System.out.println(k.getText()));
//                    propertyRecordsPage.waitForJQueryIsLoad();
                   // if (!propertyRecordsPage.getCharList().stream().allMatch(o->o.getText().startsWith(x.getText().substring(0,1))));
        });

    }

}
