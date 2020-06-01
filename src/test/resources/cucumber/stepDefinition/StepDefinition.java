package cucumber.stepDefinition;

import Udemy.Base;
import Udemy.pageObject.MainPagePF;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.io.IOException;

public class StepDefinition extends Base {
    MainPagePF mp;

    @Given("user is on the main page")
    public void user_is_on_the_main_page() throws IOException {
        driver = initDriver();
        driver.get(getUrl());
    }

    @Given("user clicks on Enter button")
    public void user_clicks_on_Enter_button() {
        mp = new MainPagePF(driver);
        mp.getLogin().click();
    }

    @When("^user login into application with login (.+) and pass (.+)$")
    public void user_login_into_application_with_login_and_pass(String string, String string2) {
        mp.getUserField().sendKeys(string);
        mp.getPasswordField().sendKeys(string2);
        mp.getEnterButton().click();
    }

    @Then("Entrance is {string}")
    public void entrance_is(String string) {
        Assert.assertTrue(driver.findElement(By.className("errortext")).isDisplayed());
        System.out.println("Entrance credentials are " + string);
		System.out.println("finished successfully");
        if (driver != null)
            driver.close();
    }
}
