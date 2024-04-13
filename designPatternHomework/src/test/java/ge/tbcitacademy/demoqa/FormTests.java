package ge.tbcitacademy.demoqa;

import com.codeborne.selenide.WebDriverRunner;
import ge.tbcitacademy.dataproviders.FormData;
import ge.tbcitacademy.dataproviders.FormDataProvider;
import ge.tbcitacademy.listeners.CustomListener;
import ge.tbcitacademy.steps.demoqawebsitesteps.FormSteps;
import io.qameta.allure.*;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.*;
import static ge.tbcitacademy.data.Constants.demoQASite;
@Epic("Selenide Homework")
@Feature("Forms tests")
@Listeners(CustomListener.class)
public class FormTests {
    FormSteps steps;
    @BeforeMethod
    public void beforeClass() {
        open(demoQASite);
        WebDriverRunner.getWebDriver().manage().window().maximize();
        steps = new FormSteps();
    }
    @AfterMethod
    public void afterClass() {
        WebDriverRunner.getWebDriver().close();
    }

    @Test(dataProvider = "formData", dataProviderClass = FormDataProvider.class)
    @Description("This test fills form with parameters from data provider file")
    @Severity(SeverityLevel.MINOR)
    @Story("Test to check a form")
    public void fillForm(String firstName, String lastName, String gender, String number) {
        steps.fillingFirstName(firstName)
                .fillingLastName(lastName)
                .genderRadioButton(gender)
                .fillingNumber(number)
                .clickingSubmitButton()
                .validateStudentName(firstName, lastName);
    }
    @Test
    @Description("This test fills form with parameters coming from xml file")
    @Parameters({"firstName", "lastName", "gender", "number"})
    @Severity(SeverityLevel.MINOR)
    @Story("Test to check a form")
    public void fillFormWithParameters(String firstName, String lastName, String gender, String number) {
        steps.fillingFirstName(firstName)
                .fillingLastName(lastName)
                .genderRadioButton(gender)
                .fillingNumber(number)
                .clickingSubmitButton()
                .validateStudentName(firstName, lastName);
    }
}
