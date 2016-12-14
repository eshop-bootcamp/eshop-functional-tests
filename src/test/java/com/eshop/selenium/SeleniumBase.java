package com.eshop.selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by LNaveen on 12/14/16.
 */
public class SeleniumBase {
    private static final String CHROME_DRIVER_PROPERTY_NAME = "webdriver.chrome.driver";
    private static final String CHROME_DRIVER_PATH = "./src/test/resources/selenium_chrome_driver_mac";
    private static final String BASE_URL = "http://localhost:3131";

    protected WebDriver getWebDriver(String url) {
        System.setProperty(CHROME_DRIVER_PROPERTY_NAME, CHROME_DRIVER_PATH);
        WebDriver driver = new ChromeDriver();
        driver.get(BASE_URL + url);
        return driver;
    }

    protected void clickAlert(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 2);
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (Exception e) {
            System.out.println("No alert");
        }
    }
}
