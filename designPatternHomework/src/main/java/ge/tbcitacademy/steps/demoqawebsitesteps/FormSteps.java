package ge.tbcitacademy.steps.demoqawebsitesteps;

import com.codeborne.selenide.Condition;
import ge.tbcitacademy.pages.demoqa.FormPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;

public class FormSteps {
    FormPage page = new FormPage();

    public FormSteps fillingFirstName(String firstName){
        page.nameInput.scrollTo();
        page.nameInput.sendKeys(firstName);
        return this;
    }
    public FormSteps fillingLastName(String lastName){
        page.lastNameInput.sendKeys(lastName);
        return this;
    }
    public FormSteps genderRadioButton(String gender){
        $x(String.format("//input[@value='%s']//following-sibling::label", gender)).click();
        return this;
    }
    public FormSteps fillingNumber(String number){
        page.phoneNumberField.sendKeys(number);
        return this;
    }
    public FormSteps clickingSubmitButton(){
        page.submitButton.click();
        return this;
    }
    public FormSteps validateStudentName(String firstName, String lastName){
        String studentName = firstName +" "+lastName;
        page.name.should(Condition.appear).shouldHave(text(studentName));
        return this;
    }

}
