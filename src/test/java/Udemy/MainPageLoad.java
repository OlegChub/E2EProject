package Udemy;

import Udemy.pageObject.MainPagePF;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class MainPageLoad extends Base {
    public static Logger log = LogManager.getLogger(MainPageLoad.class.getName());
    private WebDriver driver;

    @BeforeTest
    public void init() throws IOException {
        driver = initDriver();
        log.info("Driver is initialized");
        driver.get(getUrl());
        log.info("Main page is loaded");
    }

    @AfterTest
    public void shutDown() {
        if (driver != null)
            driver.quit();
        log.info("Driver is closed");
    }

    @Test(testName = "Main page login")
    public void test1() {
        MainPagePF mp = new MainPagePF(driver);
        mp.getLogin().click();
        mp.getUserField().sendKeys(getLogin());
        mp.getPasswordField().sendKeys(getPassword());
        mp.getReg().click();
    }
}
