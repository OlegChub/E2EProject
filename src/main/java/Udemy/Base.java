package Udemy;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {
    public WebDriver driver;
    public Properties prop;
    private String url;
    private String login;
    private String password;


    public String getUrl() {
        return url;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public WebDriver initDriver() throws IOException {
        prop = new Properties();
        FileInputStream fis = new FileInputStream("C:\\Users\\60066285\\Desktop\\java\\E2Eproject\\src\\main\\prop.properties");
        prop.load(fis);
        //для запуска тестов через mvn. Позволяет выбирать browser в Jenkins
        String browserName = System.getProperty("browser");
        //    Для запуска напрямую + обавляем ИЛИ browser ИЛИ browserName в if..else чтобы везде работало
        String browser = prop.getProperty("browser");
        url = prop.getProperty("url");
        login = prop.getProperty("login");
        password = prop.getProperty("password");

        if (browser.contains("chrome") || (browserName != null && browserName.contains("chrome"))) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\60066285\\Desktop\\java\\!drivers\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();

            if (browser.contains("headless")) {
                // headless mode - само окно браузера не запускается (браузер работает на бекэнде)
                options.setHeadless(true);
            }
            if (browserName != null && browserName.contains("headless"))
                options.setHeadless(true);

            driver = new ChromeDriver(options);
        } else if (browser.contains("firefox") || (browserName != null && browserName.contains("firefox"))) {
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\60066285\\Desktop\\java\\drivers\\geckodriver.exe");
            FirefoxOptions options = new FirefoxOptions();

            if (browser.contains("headless"))
                options.setHeadless(true);
            if (browserName != null && browserName.contains("headless"))
                options.setHeadless(true);

            driver = new FirefoxDriver(options);
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    public String takeScrnShot(String TestName, WebDriver driver) throws IOException {

        TakesScreenshot scrn = (TakesScreenshot) driver;
        File source = scrn.getScreenshotAs(OutputType.FILE);

        // Определяем дату и время, когда тест провалился, и добавляем эту инфу в название скриншота
        SimpleDateFormat sdf = new SimpleDateFormat("_dd.MM.YY_HH-mm-ss");
        String date = sdf.format(new Date());

        String path = System.getProperty("user.dir") + "\\scrns\\" + TestName + date + ".png";
        FileUtils.copyFile(source, new File(path));
        return path;
    }
}
