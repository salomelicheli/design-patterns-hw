package ge.tbcitacademy.listeners;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v122.input.Input;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.*;

import static com.codeborne.selenide.Selenide.screenshot;
import static io.qameta.allure.Allure.addAttachment;

public class CustomListener implements ITestListener {
        @Override
    public void onTestFailure(ITestResult result) {
        addAttachment("photo", "photo");
        File screenshotFile = ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.FILE);
        try (InputStream is = new FileInputStream(screenshotFile)) {
            addAttachment("error_screen.png", is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}