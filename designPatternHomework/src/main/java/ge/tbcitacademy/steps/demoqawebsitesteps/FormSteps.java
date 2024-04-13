package ge.tbcitacademy.steps.demoqawebsitesteps;

import com.codeborne.selenide.Condition;
import ge.tbcitacademy.pages.demoqa.FormPage;
import io.qameta.allure.Description;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;

public class FormSteps {
    FormPage page = new FormPage();

    @Step("Filling out first name field with a following value: {0}")
    @Description("This step fills in the first name in a field")
    public FormSteps fillingFirstName(String firstName){
        page.nameInput.scrollTo();
        page.nameInput.sendKeys(firstName);
        return this;
    }
    @Step("Filling out last name field with a following value: {0}")
    @Description("This step fills in the last name in a field")
    public FormSteps fillingLastName(String lastName){
        page.lastNameInput.sendKeys(lastName);
        return this;
    }
    @Step("Choosing an option on a gender radio button: {0}")
    @Description("This step chooses the gender")
    public FormSteps genderRadioButton(String gender){
        $x(String.format("//input[@value='%s']//following-sibling::label", gender)).click();
        return this;
    }
    @Step("Filling out phone number field with a following value: {0}")
    @Description("This step fills in the phone number in a field")
    public FormSteps fillingNumber(String number){
        page.phoneNumberField.sendKeys(number);
        return this;
    }
    @Step("Clicking on a submit button")
    @Description("This step clicks on a button that will submit the form")
    public FormSteps clickingSubmitButton(){
        page.submitButton.click();
        return this;
    }
    @Step("validating that student name is correctly displayed: {0} {1}")
    @Description("This step validates the student name that has appeared after clicking on a submit button")
    public FormSteps validateStudentName(String firstName, String lastName){
        String studentName = firstName +" "+lastName;
        page.name.should(Condition.appear).shouldHave(text(studentName));
        return this;
    }

}
