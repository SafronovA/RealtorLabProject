package com.epam.tat.realtor.drivers;

import com.epam.tat.realtor.ConfigProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Supplier;

public enum DriverFactory implements WebDriver{


    CHROMEDRIVER (()->System.setProperty("webdriver.chrome.driver", ConfigProperties.getTestProperty("chromedriver")), ChromeDriver::new),
    FIREFOXDRIVER (()->System.setProperty("webdriver.gecko.driver", ConfigProperties.getTestProperty("geckodriver")),FirefoxDriver::new);

    private WebDriver driver;

    DriverFactory (Supplier<String> stringSupplier, Supplier<WebDriver> driverSupplier){
        stringSupplier.get();
        this.driver=driverSupplier.get();
    }

    @Override
    public void get(String s) {
        this.driver.get(s);
    }

    @Override
    public String getCurrentUrl() {
        return this.driver.getCurrentUrl();
    }

    @Override
    public String getTitle() {
        return this.driver.getTitle();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return this.driver.findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        return this.driver.findElement(by);
    }

    @Override
    public String getPageSource() {
        return this.driver.getPageSource();
    }

    @Override
    public void close() {
        this.driver.close();
    }

    @Override
    public void quit() {
        this.driver.quit();
    }

    @Override
    public Set<String> getWindowHandles() {
        return this.driver.getWindowHandles();
    }

    @Override
    public String getWindowHandle() {
        return this.driver.getWindowHandle();
    }

    @Override
    public TargetLocator switchTo() {
        return this.driver.switchTo();
    }

    @Override
    public Navigation navigate() {
        return this.driver.navigate();
    }

    @Override
    public Options manage() {
        return this.driver.manage();
    }
}
