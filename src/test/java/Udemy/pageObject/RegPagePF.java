package Udemy.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegPagePF {
    private WebDriver driver;

    public RegPagePF(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(name = "USER_LAST_NAME")
    WebElement lastName;

    @FindBy(name="USER_PASSWORD")
    WebElement pass;

    @FindBy(name="USER_CONFIRM_PASSWORD")
    WebElement passConf;

    @FindBy(css="input[name='Register']")
    WebElement regBtn;

    public WebElement getLastName(){
        return lastName;
    }
    public WebElement getPass(){
        return pass;
    }
    public WebElement getPassConf(){
        return passConf;
    }
    public WebElement getRegBtn(){
        return regBtn;
    }
}
