package AutoIt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;


public class AutoIt {
    @Test
    public void pdf2jpgConverting() throws InterruptedException, IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\60066285\\Desktop\\java\\!drivers\\chromedriver.exe");
        String downloadPath = System.getProperty("user.dir") + "\\dwnloads\\";

        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", downloadPath);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);

        WebDriver driver = new ChromeDriver(options);

        driver.navigate().to("https://smallpdf.com/ru/pdf-to-jpg");
        driver.findElement(By.cssSelector("button[type='button']")).click();
        Thread.sleep(2000);

        // запускаем записанный ранее autoit.exe
        Runtime.getRuntime().exec("C:\\Users\\60066285\\Desktop\\java\\E2Eproject\\src\\test\\resources\\autoit.exe");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[class*='dsSLsN']")));
        driver.findElement(By.xpath("//div[contains(@class,'iPohUv')]/div[2]")).click();

        driver.findElement(By.cssSelector("button[class*='hKtorq']")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[class*='fIqjTd']")));
        driver.findElement(By.cssSelector("div[class*='fIqjTd']")).click();

        String filePath = downloadPath + "\\Test-изображения.zip";
        File file = new File(filePath);
        Thread.sleep(3000);

        Assert.assertTrue(file.exists());

        if (file.exists()) {
            file.delete();
        }

        if (driver != null)
            driver.close();
    }
}
