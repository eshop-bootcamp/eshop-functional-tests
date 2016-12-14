package com.eshop.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by LNaveen on 12/14/16.
 */
public class BuyersLandingPageTest extends SeleniumBase {

    private WebDriver driver;

    @Before
    public void setUp()
    {
        driver = getWebDriver("/#/landingpagebuyer");
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void shouldDisplaySeededCategoriesonLandingPage() throws InterruptedException {
        WebElement ddlCategory = driver.findElement(By.cssSelector("#ddlCategory"));
        ddlCategory.click();

        driver.findElement(By.id("category_2")).click();

        clickAlert(driver);

        String html = ddlCategory.getText();
        assert (html).contains("Clothing");
    }


}
