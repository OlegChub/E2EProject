package Udemy;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners extends Base implements ITestListener {
    //для Extent report
    ExtentTest test;
    ExtentReports extent = ExtentReportNG.getExtentObject();
    //Thread-safe чтобы запускать тесты в parallel
    ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();


    @Override
    public void onTestStart(ITestResult result) {
        //для Extent report
        test = extent.createTest(result.getMethod().getMethodName());
        //делаем test Thread-safe
        extentTest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        //для Extent report
        //вызываем Thread-safe test
        extentTest.get().log(Status.PASS, "Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        //для Extent report вызываем Thread-safe test
        extentTest.get().fail(result.getThrowable());
        WebDriver driver;

        // получаем имя метода, который выдаст ошибку и отдаем его в название скриншота (прописано в Base.class)
        String TestName = result.getMethod().getMethodName();

        // делаем привязку к driver, который будет использоваться именно в том тесте, который выдаст ошибку
        try {
            driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
            //Прикрепляем скриншот к Extent report
            extentTest.get().addScreenCaptureFromPath(takeScrnShot(TestName, driver), TestName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {
        //для Extent report
        extent.flush();
    }
}
