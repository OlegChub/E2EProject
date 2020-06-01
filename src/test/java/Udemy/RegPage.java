package Udemy;

import Udemy.pageObject.MainPagePF;
import Udemy.pageObject.RegPagePF;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class RegPage extends Base {
    private WebDriver driver;

    @BeforeTest
    public void init() throws IOException {
        driver = initDriver();
        driver.get(getUrl());
    }

    @Test(testName = "Registration page")
    public void regTest() {
        MainPagePF mp = new MainPagePF(driver);
        mp.getLogin().click();
        mp.getReg().click();
        RegPagePF rp = new RegPagePF(driver);
        rp.getLastName().sendKeys("Chub");
        rp.getPass().sendKeys(getPassword());
        rp.getPassConf().sendKeys(getPassword());
        rp.getRegBtn().click();

    }

    @AfterTest
    public void shutDown() {
            driver.quit();
    }
}
