package com.eshop.selenium;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by LNaveen on 12/14/16.
 */
public class BuyersLandingPageTest extends SeleniumBase {

    @Test
    public void shouldDisplaySeededCategoriesonLandingPage() throws InterruptedException {
        WebDriver driver = getWebDriver("/#/landingpagebuyer");
        WebElement ddlCategory = driver.findElement(By.cssSelector("#ddlCategory"));
        ddlCategory.click();

        driver.findElement(By.id("category_2")).click();

        clickAlert(driver);

        String html = ddlCategory.getText();
        assert (html).contains("Clothing");

        driver.quit();
    }


}
