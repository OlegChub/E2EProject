package Udemy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class NaviMenuElem extends Base {
    public static Logger log = LogManager.getLogger(NaviBar.class.getName());
    private WebDriver driver;

    @BeforeTest
    public void init() throws IOException {
        driver = initDriver();
        log.info("Driver is initialized");
    }

    @Test(testName = "Navigation tabs quantity")
    public void NaviBarQuantityTest() throws IOException {
        driver.get(getUrl());
        log.info("Main page is loaded");
        List<WebElement> elem = driver.findElements(By.xpath("//div[@class='catalog_menu']/ul[@class='accord']/li"));
        driver.navigate().refresh();
        if (elem.size() == 11) {
            log.info(elem.size());
            log.info("All menu tabs are present");
            Assert.assertTrue(true);
        } else {
            log.error("Menu tabs are absent");
            Assert.assertTrue(false);

        }
    }

    @AfterTest
    public void shutDown() {
        if (driver != null)
            driver.close();
        log.info("Driver is shutted down");
    }
}



