package Udemy;

import Udemy.pageObject.MainPagePF;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class NaviBar extends Base {
    public static Logger log = LogManager.getLogger(NaviBar.class.getName());
    private WebDriver driver;
    private MainPagePF mp;

    @BeforeTest
    public void init() throws IOException {
        driver = initDriver();
        log.info("Driver is initialized");
        driver.navigate().to(getUrl());
        mp = new MainPagePF(driver);
    }

    @Test(testName = "Navigation bar")
    public void NaviBarTest() throws IOException {

        log.info("Main page is loaded");
        if (mp.getNaviBar().isDisplayed()) {
            log.info("Navi bar is displayed");
        } else {
            log.error("Navi bar is NOT displayed");
        }
    }

    @Test(testName = "Phone number")
    public void checkPhoneNumber() {
        log.info("Main page is loaded");

        String phoneNum = mp.getPhoneNumber().getText();
        System.out.println(phoneNum);
        Assert.assertEquals(phoneNum,"8 (495) 374-52-83");
    }

    @AfterTest
    public void shutDown() {
        if (driver != null)
            driver.close();
        log.info("Driver is shutted down");
    }
}
