package ge.tbcitacademy.demoqa;

import com.codeborne.selenide.WebDriverRunner;
import ge.tbcitacademy.dataproviders.FormData;
import ge.tbcitacademy.dataproviders.FormDataProvider;
import ge.tbcitacademy.steps.demoqawebsitesteps.FormSteps;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;
import static ge.tbcitacademy.data.Constants.demoQASite;

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
    public void fillForm(String firstName, String lastName, String gender, String number) {
        steps.fillingFirstName(firstName)
                .fillingLastName(lastName)
                .genderRadioButton(gender)
                .fillingNumber(number)
                .clickingSubmitButton()
                .validateStudentName(firstName, lastName);
    }
    @Test
    @Parameters({"firstName", "lastName", "gender", "number"})
    public void fillFormWithParameters(String firstName, String lastName, String gender, String number) {
        steps.fillingFirstName(firstName)
                .fillingLastName(lastName)
                .genderRadioButton(gender)
                .fillingNumber(number)
                .clickingSubmitButton()
                .validateStudentName(firstName, lastName);
    }
}
