package ge.tbcitacademy.demoqa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import ge.tbcitacademy.dataproviders.FormData;
import ge.tbcitacademy.listeners.CustomListener;
import ge.tbcitacademy.steps.demoqawebsitesteps.DemoQaSteps;
import io.qameta.allure.*;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.open;
import static ge.tbcitacademy.data.Constants.Link4;

@Epic("Selenide Homework")
@Feature("Collections tests")
@Listeners(CustomListener.class)
public class CollectionsTest {
    DemoQaSteps steps;
    @BeforeMethod
    public void setUp(){
        Configuration.browser = "firefox";
        open(Link4);
        steps = new DemoQaSteps();
        Configuration.timeout = 7000;
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }
    @AfterMethod
    public void afterClass() {
        WebDriverRunner.getWebDriver().close();
    }

    @Test(dataProvider = "formData", dataProviderClass = FormData.class)
    @Severity(SeverityLevel.MINOR)
    @Description("This test types in data and then validates the data collection")
    @Story("Test to validate collections")
    public void validateCollections(String name, String email, String currentAddress, String permanentAddress) {
        steps.scrollToInput()
                .typingUsernameToField(name)
                .typingEmail(email)
                .typingCurrentAddress(currentAddress)
                .typingPermanentAddress(permanentAddress)
                .scrollingToSubmitButton()
                .clickOnSumbitButton()
                .validatingOutputField(name, email, currentAddress, permanentAddress);
    }
}
