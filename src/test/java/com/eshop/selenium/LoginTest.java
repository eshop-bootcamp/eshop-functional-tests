package com.eshop.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertNotNull;

/**
 * Created by hgurnani on 12/12/16.
 */
public class LoginTest {

    private static final String CHROME_DRIVER_PROPERTY_NAME = "webdriver.chrome.driver";
    private static final String CHROME_DRIVER_PATH = "./src/test/resources/selenium_chrome_driver_mac";
    private static final String LOGIN_URL = "http://localhost:3001/#/login";
    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        loadChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    private void loadChromeDriver() throws MalformedURLException {
        System.setProperty(CHROME_DRIVER_PROPERTY_NAME, CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
    }

    @Test
    public void testLogin() throws Exception {
        driver.get(LOGIN_URL);
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("username");

        WebElement password = driver.findElement(By.id("username"));
        password.sendKeys("password");

        WebElement loginButton = driver.findElement(By.id("login_button"));
        loginButton.click();

        assertNotNull(username.getText());
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}

