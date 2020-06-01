package Udemy;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
    static ExtentReports extent;

    public static ExtentReports getExtentObject(){

        // Указывем куда сохранять репорт
        String path=System.getProperty("user.dir")+"\\reports\\index.html";
        //это вспомогательный объект, который отвечает за настройку страницы с репортом
        ExtentSparkReporter reporter=new ExtentSparkReporter(path);
        reporter.config().setDocumentTitle("E2E project report");
        reporter.config().setReportName("E2E REPORT");

        // основной объект, который отвечает за генерацию отчетов
        extent= new ExtentReports();
        // передаем настройки конфигурации
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester","Oleg Chub");
        return extent;
    }
}
