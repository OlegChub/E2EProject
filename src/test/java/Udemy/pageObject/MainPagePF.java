package Udemy.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MainPagePF {
    private WebDriver driver;

    public MainPagePF(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Войти в кабинет")
    private WebElement login;

    @FindBy(name="Login")
    private WebElement enterButton;

    @FindBy(xpath = "//input[@name='USER_LOGIN']")
    private WebElement user;

    @FindBy(css = "input[name='USER_PASSWORD']")
    private WebElement password;

    @FindBy(linkText = "Войти по почте")
    private WebElement EnterWithEmailBtn;

    @FindBy(linkText = "Регистрация")
    private WebElement reg;

    @FindBy(css = "div[class='catalog_menu']")
    private WebElement naviBar;

    @FindBy(css="[class='comagic_phone']")
    private WebElement phoneNumber;

    public WebElement getLogin() {
        return login;
    }

    public WebElement getUserField() {
        return user;
    }

    public WebElement getPasswordField() {
        return password;
    }

    public WebElement getReg() {
        return reg;
    }

    public WebElement getEnterButton() {
        return enterButton;
    }

    public WebElement getNaviBar() {
        return naviBar;
    }

    public WebElement getPhoneNumber() { return phoneNumber;}
}
